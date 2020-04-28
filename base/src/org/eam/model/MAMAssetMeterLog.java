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

import org.compiere.model.MSysConfig;
import org.compiere.util.DB;

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
		if(meter.getAM_Meter().getType().equalsIgnoreCase("AC")){
			String sql = "SELECT COALESCE(SUM(AMT) , 0) FROM AM_AssetMeter_Log WHERE AM_AssetMeter_ID=? AND IsActive = 'Y'";
			BigDecimal accumulated =  DB.getSQLValueBD(get_TrxName(), sql, meter.get_ID());
			meter.setAccumilated(accumulated);
		}
		meter.save();
		
		//Regression analysis
		if(meter.getAM_Meter().getType().equalsIgnoreCase("AC")){//LM
			//get line count
			if(meter.getLineCount(newRecord) >= meter.getAM_Meter().getLastRecordCount()){ 
				//Eligible for Linear regression
				try {
					Date predicedDate = this.getPredicedDate(meter , 0);
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}else if(meter.getAM_Meter().getType().equalsIgnoreCase("LM")){
			
		}
		
		return success;
	}
	
	protected boolean afterDelete (boolean success)
	{
		MAMAssetMeter meter = new MAMAssetMeter(getCtx(), getAM_AssetMeter_ID(), null);
		//based on the meter type, calculate the accumulate
		if(meter.getAM_Meter().getType().equalsIgnoreCase("AC")){
			meter.setAmt(this.getAmt());
			meter.setDateTrx(getDateTrx());
			String sql = "SELECT COALESCE(SUM(AMT), 0) FROM AM_AssetMeter_Log WHERE AM_AssetMeter_ID=? AND IsActive = 'Y'";
			
			BigDecimal accumulated =  DB.getSQLValueBD(get_TrxName(), sql, meter.get_ID());
			meter.setAccumilated(accumulated);
			meter.save();
		}
		return success;
	}
	
	private Date getPredicedDate(MAMAssetMeter meter , int nextMeterReading) throws ParseException{
		
		MAMAssetMeterLog [] logs = meter.getLines(meter.getAM_Meter().getLastRecordCount());
		
		List<Integer> xaxis = new ArrayList<>(); //INDEPENDANT VARIABBLE >> METER READING
		List<Integer> yaxis = new ArrayList<>();//DEPENDANT VARIABBLE >> DATE READING
		
		String strBaseDate = MSysConfig.getValue("EAM_METER_BASE_DATE_FOR_REG_ANALYSIS", this.getAD_Client_ID());
		Date baseDate=new SimpleDateFormat("yyyy-mm-dd").parse(strBaseDate);
		
		int dayDiff = 0;
		
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
}
