/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, see http://www.gnu.org/licenses or write to the * 
 * Free Software Foundation, Inc.,                                            *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * Copyright (C) 2003-2016                                                    *
 * All Rights Reserved.                                                       *
 *****************************************************************************/
package org.eam.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MSysConfig;
import org.compiere.model.Query;
import org.compiere.util.DB;
import org.zkoss.lang.D;

/**
 * Meter class
 * @contributor Mario Calderon, Systemhaus Westfalia, http://www.westfalia-it.com
 * @contributor Adaxa http://www.adaxa.com
 * @contributor Deepak Pansheriya, Loglite Technologies, http://logilite.com
 * @contributor Victor Perez, victor.perez@e-evolution.com, eEvolution http://www.e-evolution.com
 * @contributor Yamel Senih, ysenih@erpcya.com, ERPCyA http://www.erpcya.com
 */
public class MAMAssetMeterLog extends X_AM_AssetMeter_Log {

	/**
	 * 
	 */
	private static final long serialVersionUID = 920285726461219946L;
	

	public MAMAssetMeterLog(Properties ctx, int AM_Meter_ID, String trxName) {
		super(ctx, AM_Meter_ID, trxName);
	}

	public MAMAssetMeterLog(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
	
	/*@Override
	protected boolean beforeSave(boolean newRecord) {
		
		return true;
	}*/
	
	//afterSave
	@Override
	protected boolean afterSave (boolean newRecord, boolean success)
	{
		//update header information
		MAMAssetMeter meter = new MAMAssetMeter(getCtx(), getAM_AssetMeter_ID(), null);
		meter.setAmt(this.getAmt());
		meter.setDateTrx(getDateTrx());
		
		//based on the meter type, calculate the accumulate
		if(meter.getAM_Meter().getType().equalsIgnoreCase("AC"))
			meter.setAccumilated(getAmt()); //This field will be used to calculate the regression analysis
		
		meter.save();
		
		//Update the PM action schedule
		updateCalenderSchedule(meter, newRecord);
		return success;
	}
	
	protected boolean afterDelete (boolean success)
	{
		MAMAssetMeter meter = new MAMAssetMeter(getCtx(), getAM_AssetMeter_ID(), null);
		//based on the meter type, calculate the accumulate
		if(meter.getAM_Meter().getType().equalsIgnoreCase("AC")){
			meter.setAmt(this.getAmt());
			meter.setDateTrx(getDateTrx());
			String sql = "SELECT AMT FROM AM_AssetMeter_Log WHERE AM_AssetMeter_ID = ? AND IsActive = 'Y' ORDER BY DATETRX DESC "
					+ " FETCH FIRST 1 ROWS ONLY";
			
			BigDecimal accumulated =  DB.getSQLValueBD(get_TrxName(), sql, meter.get_ID());
			meter.setAccumilated(accumulated);
			meter.save();
			
			//Update the PM action schedule
			updateCalenderSchedule(meter, false);
		}
		return success;
	}
	
	private BigDecimal getDuePercengate(MAMCalenderSchedule sc){
		
		String sql = "SELECT Scheduledmetervalue - "
		+ "(SELECT COALESCE(SUM(Scheduledmetervalue) , 0) FROM AM_CalenderSchedule  "
		+ "WHERE AM_Maintenance_ID=?  "
		+ "AND A_Asset_ID=? "
		+ "AND TYPE = 'M' "
		+ "AND Status NOT IN('OP') "
		+ "AND duepercentage >=100) "
		+ "FROM AM_CalenderSchedule WHERE AM_CalenderSchedule_ID=?";
		
		double baseAmt = DB.getSQLValue(get_TrxName(), sql, sc.getAM_Maintenance_ID(), sc.getA_Asset_ID() , sc.get_ID());
		
		sql = "SELECT MAX(amt) FROM AM_AssetMeter_Log WHERE AM_AssetMeter_ID=? AND IsAllocated = 'Y'";
		double prevMax =  DB.getSQLValue(get_TrxName(), sql, getAM_AssetMeter_ID());
		
		double DuePercentage = ((getAmt().doubleValue() - prevMax) / baseAmt) * 100;
		
		return new BigDecimal(DuePercentage).setScale(0 , RoundingMode.HALF_UP);
	}
	
	private void updateCalenderSchedule(MAMAssetMeter meter ,Boolean newRecord){
		
		//Calculate Due Percentage
		MAMCalenderSchedule sc = getMaintainceSchedule(meter.getAM_Meter_ID(), meter.getA_Asset_ID());
		
		if(sc !=null && sc.get_ID() > 0){
			
			sc.setDuePercentage(getDuePercengate(sc));
			
			//validate the due percentage as 100% and create new schedule
			if(sc.getDuePercentage().doubleValue() >= 100.00){ // the schedule is completed it is needed to create new schedule
				sc.setStatus(MAMCalenderSchedule.STATUS_InProgress);
				//copy values to new schedule
				MAMCalenderSchedule newSchedule = new MAMCalenderSchedule(getCtx(), 0, null);
				sc.copyValues(sc, newSchedule);
				
				newSchedule.setScheduledMeterValue(sc.getScheduledMeterValue()+sc.getAM_Maintenance().getMBInterval().intValue());
				newSchedule.setSeqNo(0);
				newSchedule.setStatus(MAMCalenderSchedule.STATUS_Open);
				newSchedule.setDuePercentage(new BigDecimal(0));
				
				if(sc.getAM_Maintenance().isPerformValueBase()){
					
					int overflow = meter.getAccumilated().intValue() -  sc.getScheduledMeterValue();
					newSchedule.setScheduledMeterValue(newSchedule.getScheduledMeterValue() + overflow);
				}
				
				newSchedule.save();
				
				//update the meter schedule as allocated
				String sql = "UPDATE AM_AssetMeter_Log SET IsAllocated = 'Y' WHERE IsAllocated = 'N' AND AM_AssetMeter_ID=?";
				DB.executeUpdate(sql, meter.get_ID(), get_TrxName());
			}
			
			sc.save();
		}
		
		//Regression analysis
		if(meter.getAM_Meter().getType().equalsIgnoreCase("AC")){//Accumilated
			
			//get line count
			if(meter.getLineCount(newRecord) >= meter.getAM_Meter().getMinRecords()){
				
				//Eligible for Linear regression
				if(sc !=null && sc.get_ID() > 0){
					
					Date predicedDate = this.getPredicedDate(meter , sc.getScheduledMeterValue());
					
					if(predicedDate !=null){
						sc.setDateScheduled(new Timestamp(predicedDate.getTime()));
						sc.save();
					}
					
				}else{
					//Here there is no PM action is scheduled.. Nothing to do in here
				}
			}
			
		}else if(meter.getAM_Meter().getType().equalsIgnoreCase("LM")){ //Limit
			
		}
	
	}
	
	private Date getPredicedDate(MAMAssetMeter meter , int nextMeterReading){
		
		List<MAMAssetMeterLog> list = new Query(getCtx(), "AM_AssetMeter_Log","AM_AssetMeter_ID = ? ", null)
				.setParameters(meter.get_ID())
				.setOnlyActiveRecords(true)
				.setLimit(meter.getAM_Meter().getMaxRecords())
				.setOrderBy("AM_AssetMeter_Log_ID DESC")
				.list();
		
		MAMAssetMeterLog [] logs = list.toArray(new MAMAssetMeterLog[list.size()]);
		
		if(logs.length == 0) //No date
			return null;
		
		List<Integer> xaxis = new ArrayList<>(); //INDEPENDANT VARIABBLE >> METER READING
		List<Integer> yaxis = new ArrayList<>();//DEPENDANT VARIABBLE >> DATE READING
		
		String strBaseDate = MSysConfig.getValue("EAM_METER_BASE_DATE_FOR_REG_ANALYSIS", this.getAD_Client_ID());
		
		Date baseDate = null;
		try{
			baseDate = new SimpleDateFormat("yyyy-mm-dd").parse(strBaseDate);
		}catch(Exception e){
			//throw new AdempiereException(e.getMessage());
			e.printStackTrace();
		}
		
		int dayDiff = 0;
		//int meterSum = 0;
		
		for(MAMAssetMeterLog log : logs){
			
			//Meter reading
			xaxis.add(log.getAmt().intValue());
			//Convert date to integer
			dayDiff = (int) ((log.getDateTrx().getTime() - baseDate.getTime()) / (1000*60*60*24));
			yaxis.add(dayDiff);
		}
		
		Double res = LinearRegression.predictForValue(nextMeterReading, xaxis, yaxis);
		
		BigDecimal bd = new BigDecimal(res);
	    bd = bd.setScale(1, RoundingMode.HALF_UP);
		
	    Calendar c = Calendar.getInstance();
	    c.setTime(baseDate);
	    c.add(Calendar.DAY_OF_YEAR,  bd.intValue());
	    
		return c.getTime();
	}
	
	private MAMCalenderSchedule getMaintainceSchedule(int AM_Meter_ID , int A_Asset_ID){
		
		String sql = "SELECT cs.AM_CalenderSchedule_ID FROM "
			+ "AM_CalenderSchedule cs "
			+ "INNER JOIN AM_Maintenance mt ON mt.AM_Maintenance_ID = cs.AM_Maintenance_ID "
			+ "AND mt.docstatus = 'CO' WHERE "
			+ "cs.TYPE = 'M' "
			+ "AND mt.AM_Meter_ID=? " // --Parameter 
			+ "AND mt.validfrom <= CURRENT_DATE " //--Parameter 
			+ "AND mt.validto > CURRENT_DATE " //--Parameter 
			+ "AND cs.status = 'OP' "
			+ "AND cs.A_Asset_ID = ? " //--Parameter 
			+ "AND mt.AD_Client_ID = ?"//--Parameter 
			+ "AND mt.AD_Org_ID = ?";//--Parameter
		
		Object [] str_param = new Object[]{AM_Meter_ID , A_Asset_ID , getAD_Client_ID() , getAD_Org_ID()};
		int AM_CalenderSchedule_ID = DB.getSQLValue(get_TrxName(), sql , str_param);
		
		return new MAMCalenderSchedule(getCtx(), AM_CalenderSchedule_ID, get_TrxName()); 
	}
}
