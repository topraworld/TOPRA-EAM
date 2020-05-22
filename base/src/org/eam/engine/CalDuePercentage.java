package org.eam.engine;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;

import org.compiere.process.SvrProcess;
import org.compiere.util.CPreparedStatement;
import org.compiere.util.DB;
import org.eam.model.MAMCalenderSchedule;
import org.eam.model.MAMMaintenance;

//PM Action - Calender base date updator
//org.eam.engine.CalDuePercentage
public class CalDuePercentage extends SvrProcess{

	@Override
	protected void prepare() { }

	@Override
	protected String doIt() throws Exception {
		
		String sql = "SELECT "
			+ "M.AM_Maintenance_ID , "
			+ "MIN(sc.SeqNo) as SeqNo FROM AM_CalenderSchedule sc "
			+ "INNER JOIN AM_Maintenance M "
			+ "ON sc.AM_Maintenance_ID = M .AM_Maintenance_ID "
			+ "WHERE sc. TYPE = 'C' AND "
			+ "sc.status = 'OP' AND "
			+ "sc.isactive = 'Y' AND "
			+ "M.validto > CURRENT_DATE AND "
			+ "M .docstatus = 'CO' "
			+ "GROUP BY 1 ";
		
		CPreparedStatement ps = null;
		ResultSet rs = null;
		BigDecimal divisor  = new BigDecimal(0) , denominator = new BigDecimal(0);
		BigDecimal percentage = new BigDecimal(0);
		
		try {
			ps = DB.prepareStatement(sql, null);
			rs = ps.executeQuery();
			
			MAMMaintenance maintenance = null; 
			MAMCalenderSchedule cs = null , csPrevious = null , csAfter = null;
			
			while(rs.next()){
				
				maintenance = new MAMMaintenance(getCtx(), rs.getInt("AM_Maintenance_ID"), null);
				cs = maintenance.getCalenderSchedule(rs.getInt("SeqNo"));
				
				if(cs.getSeqNo() == 1){ //calculate with schedule valid fro date
					csAfter = maintenance.getCalenderSchedule(cs.getSeqNo()+1);
					divisor = new BigDecimal(csAfter.getDateScheduled().getTime() - cs.getDateScheduled().getTime());
				}else{
					csPrevious = maintenance.getCalenderSchedule(cs.getSeqNo()-1);
					divisor = new BigDecimal(cs.getDateScheduled().getTime() - csPrevious.getDateScheduled().getTime());
				}
				
				//divisor = divisor / ;
				divisor = divisor.divide(new BigDecimal((24 * 60 * 60 * 1000)) , 0 , RoundingMode.HALF_UP);
				
				denominator = new BigDecimal(cs.getDateScheduled().getTime() - System.currentTimeMillis());
				denominator = denominator.divide(new BigDecimal((24 * 60 * 60 * 1000)) , 0 , RoundingMode.HALF_UP);
				
				percentage = denominator.divide(divisor , 2 , RoundingMode.HALF_UP).multiply(new BigDecimal(100));
				percentage = percentage.setScale(0, RoundingMode.HALF_UP);
				
				cs.setDuePercentage(percentage);
				cs.save();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null && ps != null){
				DB.close(rs, ps);
				
				rs = null;
				ps = null;
			}
		}
		return "Done!";
	}
}
