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
import java.util.List;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.process.DocAction;
import org.compiere.process.DocOptions;
import org.compiere.process.DocumentEngine;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.KeyNamePair;
import org.jruby.RubyBoolean.True;

/** Generated Model for AM_ServiceOrder
 *  @author Adempiere (generated) 
 *  @version Release 3.9.3 - $Id$ */
public class MAMServiceOrder extends X_AM_ServiceOrder implements DocAction , DocOptions {

	/**
	 *
	 */
	private static final long serialVersionUID = 20200421L;

    /** Standard Constructor */
    public MAMServiceOrder (Properties ctx, int AM_ServiceOrder_ID, String trxName)
    {
      super (ctx, AM_ServiceOrder_ID, trxName);
    }

    /** Load Constructor */
    public MAMServiceOrder (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }
    
    protected boolean beforeSave (boolean newRecord){
    	
		return true;
	}
    
    protected boolean afterSave (boolean newRecord, boolean success) {
    	//coping PM action task list
		return success;
	}	//	afterSave

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
		
		//update the calendar schedule based on the work order doc action 
		MAMCalenderSchedule cs = (MAMCalenderSchedule) getAM_CalenderSchedule();
		
		if(cs != null && cs.get_ID() > 0) {
			
			if(getDocAction().equals("PR") || getDocAction().equals("RE"))
				cs.setStatus(DOCSTATUS_InProgress);
			else if(getDocAction().equals("CO"))
				cs.setStatus(DOCSTATUS_Completed);
			else if(getDocAction().equals("CL"))
				cs.setStatus(DOCSTATUS_Closed);
			else if(getDocAction().equals("VO"))
				cs.setStatus(DOCSTATUS_Voided);
			
			cs.save();
		}
		
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
		
		String sql = "";
		//coping PM action task list
		if(getAM_Maintenance_ID() > 0){
			
			//set Maintenance area
			setAM_MaintenanceArea_ID(getAM_Maintenance().getAM_MaintenanceArea_ID());
			
			//delete existing task list
			sql = "DELETE FROM AM_ServiceOrderTask where AM_ServiceOrder_ID = ? AND AM_Maintenance_ID = ?";
			DB.executeUpdate(sql,new Object[]{get_ID(),getAM_Maintenance_ID()},true,null);
			
			List<MAMMaintenanceTask> list = new Query(getCtx(), MAMMaintenanceTask.Table_Name, "AM_Maintenance_ID=?", null)
				.setParameters(getAM_Maintenance_ID())
				.setOnlyActiveRecords(true)
				.list();
			
			MAMServiceOrderTask orderTask = null;
			MAMMaintenanceResource [] maintenanceResources = null;
			MAMServiceOrderResource serviceRes = null;
			
			//Coping each task from PM Action
			for (MAMMaintenanceTask mTask : list) {
				
				orderTask = new MAMServiceOrderTask(getCtx(), 0, null);
				orderTask.setAM_ServiceOrder_ID(get_ID());
				orderTask.setAM_Maintenance_ID(getAM_Maintenance_ID());
				orderTask.setName(mTask.getName());
				orderTask.setC_UOM_ID(mTask.getC_UOM_ID());
				orderTask.setDuration(mTask.getDuration());
				orderTask.setDescription(mTask.getDescription());
				orderTask.setAM_Maintenance_Task_ID(mTask.get_ID());
				orderTask.save();
				
				maintenanceResources = mTask.getResources();
				//Coping each task wise resources from PM Action
				for(MAMMaintenanceResource mres :maintenanceResources){
					serviceRes = new MAMServiceOrderResource(getCtx(), 0, null);
					serviceRes.setAM_ServiceOrderTask_ID(orderTask.get_ID());
					serviceRes.setAM_ServiceOrder_ID(get_ID());
					serviceRes.setM_Product_ID(mres.getM_Product_ID());
					serviceRes.setC_UOM_ID(mres.getC_UOM_ID());
					serviceRes.setProductType(mres.getProductType());
					serviceRes.setQtyPlan(mres.getQtyRequired());
					serviceRes.setPrice(mres.getPrice());
					serviceRes.setCostAmtPlan(mres.getCostAmt());
					serviceRes.save();
				}
			}
		}
		
		//	Add up Amounts
		m_processMsg = ModelValidationEngine.get().fireDocValidate(this, ModelValidator.TIMING_AFTER_PREPARE);
		if (m_processMsg != null)
			return DocAction.STATUS_Invalid;
		m_justPrepared = true;
		if (!DOCACTION_Complete.equals(getDocAction()))
			setDocAction(DOCACTION_Complete);
		return DocAction.STATUS_InProgress;
	}	//	prepareIt
	
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
		
		//COMPLETE ALL TASK
		//getTa
		//	Set Definitive Document No
		setDefiniteDocumentNo();

		setProcessed(true);
		setDocAction(DOCACTION_Close);
		
		//update the calender schedule
		
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
		setProcessed(true);
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
		setDocAction(DOCACTION_Complete);
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
      StringBuffer sb = new StringBuffer ("MAMServiceOrder[")
        .append(getSummary()).append("]");
      return sb.toString();
    }
    
    public void setProcessed (boolean Processed) {
    	
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
		
		//set Task & Resources as processed
		String sql = "UPDATE AM_ServiceOrderTask SET Processed = '"+ (Processed?'Y': 'N')+"' WHERE AM_ServiceOrder_ID = ?";
		DB.executeUpdate(sql, get_ID(), null);
		
		sql = "UPDATE AM_ServiceOrderResource SET Processed = '"+ (Processed?'Y': 'N')+"' WHERE AM_ServiceOrder_ID = ?";
		DB.executeUpdate(sql, get_ID(), null);
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
      		//options[index++] = DocumentEngine.ACTION_ReActivate;
      		options[index++] = DocumentEngine.ACTION_Void;
      		options[index++] = DocumentEngine.ACTION_ReActivate;
      	}
  		return index;
  	}
}