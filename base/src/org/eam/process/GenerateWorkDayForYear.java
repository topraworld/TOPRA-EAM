package org.eam.process;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.adempiere.exceptions.AdempiereException;
import org.apache.commons.net.ntp.TimeStamp;
import org.compiere.model.MClient;
import org.compiere.model.MPeriod;
import org.compiere.model.MYear;
import org.compiere.model.Query;
import org.compiere.process.SvrProcess;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.eam.model.MAMWorkDayCalander;

//org.eam.process.GenerateWorkDayForYear
public class GenerateWorkDayForYear extends SvrProcess{

	private MYear year;
	
	@Override
	protected void prepare() {
		year = new MYear(getCtx(), this.getRecord_ID(), null);
		//System.out.println("Year : " + year);
	}

	@Override
	protected String doIt() throws Exception {
		
		List<MPeriod> periods = new Query(getCtx(), MPeriod.Table_Name, "C_Year_ID=?", null)
			.setParameters(this.getRecord_ID())
			.setOrderBy(MPeriod.COLUMNNAME_PeriodNo)
			.list();
		
		//if the periods is not created
		if(periods.isEmpty())
			throw new AdempiereException("Periods not open for this year : " + year.getYearAsInt());
		
		MClient client = MClient.get(getCtx());
		Locale locale = client.getLocale();
		
		if (locale == null && Language.getLoginLanguage() != null)
			locale = Language.getLoginLanguage().getLocale();
		if (locale == null)
			locale = Env.getLanguage(getCtx()).getLocale();
		
		GregorianCalendar cal = new GregorianCalendar(locale);
		int count = 1;
		MAMWorkDayCalander mDayCalander = null;
		
		for(MPeriod period : periods){
			cal.setTimeInMillis(period.getStartDate().getTime());
			while(cal.getTimeInMillis() <= period.getEndDate().getTime()){
				mDayCalander = new MAMWorkDayCalander(getCtx() , 0 , null);
				mDayCalander.setC_Year_ID(period.getC_Year_ID());
				mDayCalander.setC_Period_ID(period.get_ID());
				mDayCalander.setDate1(new Timestamp(cal.getTimeInMillis()));
				mDayCalander.setSeqNo(count);
				mDayCalander.setWeekDay(cal.get(cal.DAY_OF_WEEK)+"");
				//setting working non working day
				if(cal.get(cal.DAY_OF_WEEK) == Integer.parseInt(mDayCalander.WEEKDAY_Sunday))
					mDayCalander.setIsWorkingDay(year.get_ValueAsBoolean("IsSunday"));
				else if(cal.get(cal.DAY_OF_WEEK) == Integer.parseInt(mDayCalander.WEEKDAY_Monday))
					mDayCalander.setIsWorkingDay(year.get_ValueAsBoolean("IsMonday"));
				else if(cal.get(cal.DAY_OF_WEEK) == Integer.parseInt(mDayCalander.WEEKDAY_Tuesday))
					mDayCalander.setIsWorkingDay(year.get_ValueAsBoolean("IsTuesday"));
				else if(cal.get(cal.DAY_OF_WEEK) == Integer.parseInt(mDayCalander.WEEKDAY_Wednesday))
					mDayCalander.setIsWorkingDay(year.get_ValueAsBoolean("IsWednesday"));
				else if(cal.get(cal.DAY_OF_WEEK) == Integer.parseInt(mDayCalander.WEEKDAY_Thursday))
					mDayCalander.setIsWorkingDay(year.get_ValueAsBoolean("IsThursday"));
				else if(cal.get(cal.DAY_OF_WEEK) == Integer.parseInt(mDayCalander.WEEKDAY_Friday))
					mDayCalander.setIsWorkingDay(year.get_ValueAsBoolean("IsFriday"));
				else if(cal.get(cal.DAY_OF_WEEK) == Integer.parseInt(mDayCalander.WEEKDAY_Saturday))
					mDayCalander.setIsWorkingDay(year.get_ValueAsBoolean("IsSaturday"));
				
				mDayCalander.save();
				
				cal.add(Calendar.DATE, 1);
				count++;
			}
		}
		return "Created days : " + count;
	}
}
