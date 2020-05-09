/******************************************************************************
 * Product: ADempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 2006-2017 ADempiere Foundation, All Rights Reserved.         *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * or (at your option) any later version.										*
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * or via info@adempiere.net or http://www.adempiere.net/license.html         *
 *****************************************************************************/
package org.eam.model;

import java.io.File;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.*;
import org.compiere.process.DocAction;
import org.compiere.process.DocOptions;
import org.compiere.process.DocumentEngine;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Language;
import org.compiere.util.Trx;

/** Generated Model for AM_Maintenance
 *  @author Adempiere (generated) 
 *  @version Release 3.9.3 - $Id$ */
public class MAMMaintenance extends X_AM_Maintenance implements DocAction , DocOptions{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200409L;

    /** Standard Constructor */
    public MAMMaintenance (Properties ctx, int AM_Maintenance_ID, String trxName)
    {
      super (ctx, AM_Maintenance_ID, trxName);
    }

    /** Load Constructor */
    public MAMMaintenance (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

	/**
	 * 	Get Document Info
	 *	@return document info (untranslated)
	 */
	public String getDocumentInfo()
	{
		MDocType dt = MDocType.get(getCtx(), getC_DocType_ID());
		return dt.getName() + " " + getDocumentNo();
	}	//	getDocumentInfo

	/**
	 * 	Create PDF
	 *	@return File or null
	 */
	public File createPDF ()
	{
		try
		{
			File temp = File.createTempFile(get_TableName() + get_ID() +"_", ".pdf");
			return createPDF (temp);
		}
		catch (Exception e)
		{
			log.severe("Could not create PDF - " + e.getMessage());
		}
		return null;
	}	//	getPDF

	/**
	 * 	Create PDF file
	 *	@param file output file
	 *	@return file if success
	 */
	public File createPDF (File file)
	{
	//	ReportEngine re = ReportEngine.get (getCtx(), ReportEngine.INVOICE, getC_Invoice_ID());
	//	if (re == null)
			return null;
	//	return re.getPDF(file);
	}	//	createPDF

	
	/**************************************************************************
	 * 	Process document
	 *	@param processAction document action
	 *	@return true if performed
	 */
	public boolean processIt (String processAction)
	{
		m_processMsg = null;
		DocumentEngine engine = new DocumentEngine (this, getDocStatus());
		return engine.processIt (processAction, getDocAction());
	}	//	processIt
	
	/**	Process Message 			*/
	private String		m_processMsg = null;
	/**	Just Prepared Flag			*/
	private boolean		m_justPrepared = false;

	/**
	 * 	Unlock Document.
	 * 	@return true if success 
	 */
	public boolean unlockIt()
	{
		log.info("unlockIt - " + toString());
	//	setProcessing(false);
		return true;
	}	//	unlockIt
	
	/**
	 * 	Invalidate Document
	 * 	@return true if success 
	 */
	public boolean invalidateIt()
	{
		log.info("invalidateIt - " + toString());
		setDocAction(DOCACTION_Prepare);
		return true;
	}	//	invalidateIt
	
	/**
	 *	Prepare Document
	 * 	@return new status (In Progress or Invalid) 
	 */
	public String prepareIt()
	{
		
		log.info(toString());
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_BEFORE_PREPARE);
		if (m_processMsg != null)
			return DocAction.STATUS_Invalid;
		
		//validation on PM action has task and resources
		int count = MAMMaintenanceTask.getTaskCount(getCtx(), this.get_ID(), null);
		if(count == 0)
			throw new AdempiereException("Error - PM Action has no tasks!");
		
		//validation on PM action has no time based and meter based selection
		if(this.getAM_Meter_ID() == 0 && this.getCBTimeUnit() == null)
			throw new AdempiereException("Error - No Time Unit or Meter is selected!");
		
		//validation or Fixed asset or asset group
		if(getA_Asset_ID() == 0 && getA_Asset_Group_ID() == 0)
			throw new AdempiereException("Error - Asset or Asset group is selected!");
		
		//delete existing schedule
		String sql = "DELETE FROM AM_CalenderSchedule WHERE AM_Maintenance_ID = ?";
		DB.executeUpdate(sql,this.get_ID() , null);
		
		//If the PM Action is selected a asset group, Then it is needed to create a row for each fixed asset.
		if(getA_Asset_Group_ID() > 0){
			List<MAsset> assets = new Query(getCtx(),MAsset.Table_Name,MAsset.COLUMNNAME_A_Asset_Group_ID + " = ?" ,null)
			.setOnlyActiveRecords(true)
			.setParameters(getA_Asset_Group_ID())
			.list();
			
			assets.forEach(asset ->{
				//CALENDAR BASED MAINTAINCE IS AVAILABLE
				if(this.getCBTimeUnit() != null && this.getCBTimeUnit().length() != 0)
					this.createCalendarBasedSchedule(asset.getA_Asset_ID());
				//METER BASED MAINTAINCE IS AVAILABLE
				if(this.getAM_Meter_ID() > 0) // there are
					this.createMeterBasedSchedule(asset.getA_Asset_ID());
			});
			
		}else if(getA_Asset_ID() > 0){
			//CALENDAR BASED MAINTAINCE IS AVAILABLE
			if(this.getCBTimeUnit() != null && this.getCBTimeUnit().length() != 0)
				this.createCalendarBasedSchedule(getA_Asset_ID());
			//METER BASED MAINTAINCE IS AVAILABLE
			if(this.getAM_Meter_ID() > 0) // there are
				this.createMeterBasedSchedule(getA_Asset_ID());
		}
		
		//Copy from Work task template
		/*if(getAM_MaintenancePatern_ID() > 0){
			
		}*/
		
		//	Add up Amounts
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_AFTER_PREPARE);
		if (m_processMsg != null)
			return DocAction.STATUS_Invalid;
		m_justPrepared = true;
		if (!DOCACTION_Complete.equals(getDocAction()))
			setDocAction(DOCACTION_Complete);
		return DocAction.STATUS_InProgress;
	}	//	prepareIt
	
	private void createMeterBasedSchedule(int A_Asset_ID){
		
		//Start value
		if(this.getMBStartValue() == 0)
			throw new AdempiereException("Please specify a Start Value for Meter based maintaince!");
		if(this.getMBInterval().intValue() == 0)
			throw new AdempiereException("Please specify a interval for Meter based maintaince!");
		
		//CREATE START METER BASED SCHEDULE
		MAMCalenderSchedule sc = new MAMCalenderSchedule(getCtx(), 0, get_TrxName());
		sc.setAM_Maintenance_ID(this.get_ID());
		//sc.setSeqNo(1);
		sc.setStatus(MAMCalenderSchedule.STATUS_Open);
		sc.setType(MAMCalenderSchedule.TYPE_Meter);
		sc.setIsWOGeneratable(true);
		sc.setDuePercentage(new BigDecimal(0));
		sc.setA_Asset_ID(A_Asset_ID);
		//sc.setDateScheduled(this.getValidFrom());
		sc.setScheduledMeterValue(getMBStartValue());
		sc.save();
	}
	
	//create calendar based maintains schedule
	private void createCalendarBasedSchedule(int A_Asset_ID){
		
		//Time Unit
		if(this.getCBInterval().intValue() == 0)
			throw new AdempiereException("Please specify a interval for Calendar based maintaince!");
		
		//create schedule
		MClient client = MClient.get(getCtx());
		Locale locale = client.getLocale();
		
		if (locale == null && Language.getLoginLanguage() != null)
			locale = Language.getLoginLanguage().getLocale();
		if (locale == null)
			locale = Env.getLanguage(getCtx()).getLocale();
		
		GregorianCalendar calSceduled = new GregorianCalendar(locale);
		calSceduled.setTimeInMillis(this.getValidFrom().getTime());
		
		GregorianCalendar calPreSceduled = new GregorianCalendar(locale);
		calPreSceduled.setTimeInMillis(this.getValidFrom().getTime());
		calPreSceduled.add(Calendar.DATE, this.getLeadTime() * -1);
		
		int count = 1 , timeUnit = 1;
		
		MAMCalenderSchedule sc = null;
		while(calSceduled.getTimeInMillis() <= this.getValidTo().getTime()){
			sc = new MAMCalenderSchedule(getCtx(), 0, get_TrxName());
			sc.setAM_Maintenance_ID(this.get_ID());
			sc.setSeqNo(count);
			sc.setStatus(MAMCalenderSchedule.STATUS_Open);
			sc.setType(MAMCalenderSchedule.TYPE_Calander);
			sc.setIsWOGeneratable(true);
			sc.setDuePercentage(new BigDecimal(0));
			sc.setA_Asset_ID(A_Asset_ID);
			
			
			sc.setDateScheduled(new Timestamp(calSceduled.getTimeInMillis()));
			
			if(this.getCBTimeUnit().equalsIgnoreCase("I")) 
				timeUnit = Calendar.MINUTE;
			else if(this.getCBTimeUnit().equalsIgnoreCase("H"))
				timeUnit = Calendar.HOUR;
			else if(this.getCBTimeUnit().equalsIgnoreCase("D"))
				timeUnit = Calendar.DATE;
			else if(this.getCBTimeUnit().equalsIgnoreCase("W"))
				timeUnit = Calendar.WEEK_OF_YEAR;
			else if(this.getCBTimeUnit().equalsIgnoreCase("M"))
				timeUnit = Calendar.MONTH;
			else if(this.getCBTimeUnit().equalsIgnoreCase("Y"))
				timeUnit = Calendar.YEAR;
			
			//adding lead time
			if(
				this.getCBTimeUnit().equalsIgnoreCase("W") ||
				this.getCBTimeUnit().equalsIgnoreCase("M") ||
				this.getCBTimeUnit().equalsIgnoreCase("Y")
			){	
				
				sc.setPreDateScheduled(new Timestamp(calPreSceduled.getTimeInMillis()));
			}
			
			sc.save();
			count++;
			
			calSceduled.add(timeUnit, this.getCBInterval().intValue());
			calPreSceduled.add(timeUnit, this.getCBInterval().intValue());
		}
	}
	
	/**
	 * 	Approve Document
	 * 	@return true if success 
	 */
	public boolean  approveIt()
	{
		log.info("approveIt - " + toString());
		setIsApproved(true);
		return true;
	}	//	approveIt
	
	/**
	 * 	Reject Approval
	 * 	@return true if success 
	 */
	public boolean rejectIt()
	{
		log.info("rejectIt - " + toString());
		setIsApproved(false);
		return true;
	}	//	rejectIt
	
	/**
	 * 	Complete Document
	 * 	@return new status (Complete, In Progress, Invalid, Waiting ..)
	 */
	public String completeIt()
	{
		//	Re-Check
		if (!m_justPrepared)
		{
			String status = prepareIt();
			if (!DocAction.STATUS_InProgress.equals(status))
				return status;
		}

		m_processMsg = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_BEFORE_COMPLETE);
		if (m_processMsg != null)
			return DocAction.STATUS_Invalid;
		
		//	Implicit Approval
		if (!isApproved())
			approveIt();
		log.info(toString());
		//
		
		//	User Validation
		String valid = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_AFTER_COMPLETE);
		if (valid != null)
		{
			m_processMsg = valid;
			return DocAction.STATUS_Invalid;
		}
		//	Set Definitive Document No
		setDefiniteDocumentNo();

		setProcessed(true);
		setDocAction(DOCACTION_Close);
		return DocAction.STATUS_Completed;
	}	//	completeIt
	
	/**
	 * 	Set the definite document number after completed
	 */
	private void setDefiniteDocumentNo() {
		MDocType dt = MDocType.get(getCtx(), getC_DocType_ID());
		if (dt.isOverwriteDateOnComplete()) {
			setDateDoc(new Timestamp(System.currentTimeMillis()));
		}
		if (dt.isOverwriteSeqOnComplete()) {
			String value = null;
			int index = p_info.getColumnIndex("C_DocType_ID");
			if (index == -1)
				index = p_info.getColumnIndex("C_DocTypeTarget_ID");
			if (index != -1)		//	get based on Doc Type (might return null)
				value = DB.getDocumentNo(get_ValueAsInt(index), get_TrxName(), true);
			if (value != null) {
				setDocumentNo(value);
			}
		}
	}

	/**
	 * 	Void Document.
	 * 	Same as Close.
	 * 	@return true if success 
	 */
	public boolean voidIt()
	{
		log.info("voidIt - " + toString());
		return closeIt();
	}	//	voidIt
	
	/**
	 * 	Close Document.
	 * 	Cancel not delivered Qunatities
	 * 	@return true if success 
	 */
	public boolean closeIt()
	{
		log.info("closeIt - " + toString());

		//	Close Not delivered Qty
		setDocAction(DOCACTION_None);
		return true;
	}	//	closeIt
	
	/**
	 * 	Reverse Correction
	 * 	@return true if success 
	 */
	public boolean reverseCorrectIt()
	{
		log.info("reverseCorrectIt - " + toString());
		return false;
	}	//	reverseCorrectionIt
	
	/**
	 * 	Reverse Accrual - none
	 * 	@return true if success 
	 */
	public boolean reverseAccrualIt()
	{
		log.info("reverseAccrualIt - " + toString());
		return false;
	}	//	reverseAccrualIt
	
	/** 
	 * 	Re-activate
	 * 	@return true if success 
	 */
	public boolean reActivateIt()
	{
		log.info("reActivateIt - " + toString());
		setProcessed(false);
		
		return true;
	}	//	reActivateIt
	
	
	/*************************************************************************
	 * 	Get Summary
	 *	@return Summary of Document
	 */
	public String getSummary()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(getDocumentNo());
	//	sb.append(": ")
	//		.append(Msg.translate(getCtx(),"TotalLines")).append("=").append(getTotalLines())
	//		.append(" (#").append(getLines(false).length).append(")");
		//	 - Description
		if (getDescription() != null && getDescription().length() > 0)
			sb.append(" - ").append(getDescription());
		return sb.toString();
	}	//	getSummary

	/**
	 * 	Get Process Message
	 *	@return clear text error message
	 */
	public String getProcessMsg()
	{
		return m_processMsg;
	}	//	getProcessMsg
	
	/**
	 * 	Get Document Owner (Responsible)
	 *	@return AD_User_ID
	 */
	public int getDoc_User_ID()
	{
	//	return getSalesRep_ID();
		return 0;
	}	//	getDoc_User_ID

	/**
	 * 	Get Document Approval Amount
	 *	@return amount
	 */
	public BigDecimal getApprovalAmt()
	{
		return null;	//getTotalLines();
	}	//	getApprovalAmt
	
	/**
	 * 	Get Document Currency
	 *	@return C_Currency_ID
	 */
	public int getC_Currency_ID()
	{
	//	MPriceList pl = MPriceList.get(getCtx(), getM_PriceList_ID());
	//	return pl.getC_Currency_ID();
		return 0;
	}	//	getC_Currency_ID

    @Override
    public String toString()
    {
      StringBuffer sb = new StringBuffer ("MAMMaintenance[")
        .append(getSummary()).append("]");
      return sb.toString();
    }

    @Override
  	public int customizeValidActions(String docStatus, Object processing, String orderType, String isSOTrx,
  			int AD_Table_ID, String[] docAction, String[] options, int index) {
  		if (docStatus.equals(DocumentEngine.STATUS_Drafted)
      			|| docStatus.equals(DocumentEngine.STATUS_Invalid)) {
      		options[index++] = DocumentEngine.ACTION_Prepare;
      	}
      	// If status = Completed, add "Reactivate" in the list
      	if (docStatus.equals(DocumentEngine.STATUS_Completed)) {
      		options[index++] = DocumentEngine.ACTION_ReActivate;
      		options[index++] = DocumentEngine.ACTION_Void;
      	}
  		return index;
  	}
    
    
}