package org.eam.model;

import java.io.File;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.MDocType;
import org.compiere.model.MSequence;
import org.compiere.process.DocAction;
import org.compiere.process.DocOptions;
import org.compiere.process.DocumentEngine;

public class MAMMaintenancePattern  extends X_AM_MaintenancePattern implements DocAction , DocOptions{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean		m_justPrepared = false;

	public MAMMaintenancePattern(Properties ctx, int AM_MaintenancePattern_ID, String trxName) {
		super(ctx, AM_MaintenancePattern_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	public MAMMaintenancePattern(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	protected boolean beforeSave (boolean newRecord){
		
		return true;
	}
	
	protected boolean afterSave (boolean newRecord, boolean success)
	{	
		//setting up the document no
		if(newRecord){
			MDocType dt = (MDocType)this.getC_DocType();
			MSequence seq = (MSequence) dt.getDocNoSequence();
			if(seq == null || seq.get_ID() <= 0) return success;
				
			String DocumentNo = (seq.getPrefix() == null?"":seq.getPrefix()) + seq.getCurrentNext() + (seq.getSuffix() == null?"":seq.getSuffix());
			seq.setCurrentNext(seq.getCurrentNext() + seq.getIncrementNo());
			seq.save();
			
			this.setDocumentNo(DocumentNo);
			this.save();
		}
			
		return success;
	}

	@Override
	public boolean processIt(String action) throws Exception {
		
		System.out.println("action : " + action);
		System.out.println("getDocStatus() : " + getDocStatus());
		System.out.println("getDocAction() : " + getDocAction());
		
		//Prepare the price document
		if(action.equals("--")
			&& getDocStatus().equalsIgnoreCase("DR") 
			&& getDocAction().equalsIgnoreCase("PR")){
				this.prepareIt();
		}else if(action.equals("CO") 
				&& getDocStatus().equalsIgnoreCase("DR") 
				&& getDocAction().equalsIgnoreCase("CO")
				&& !m_justPrepared){
			this.completeIt();
		}else if(action.equals("--") 
				&& getDocStatus().equalsIgnoreCase("CO") 
				&& getDocAction().equalsIgnoreCase("RE")
				&& !m_justPrepared){
			this.reActivateIt();
		}else if(action.equals("--") 
				&& getDocStatus().equalsIgnoreCase("CO") 
				&& getDocAction().equalsIgnoreCase("VO")
				&& !m_justPrepared){
			this.voidIt();
		}
		return true;
	}

	@Override
	public boolean unlockIt() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean invalidateIt() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String prepareIt() {
		//validate lines
		m_justPrepared = true;
		this.setDocStatus("IP");
		this.setDocAction(DocAction.ACTION_Complete);
		
		return "Done!";
	}

	@Override
	public boolean approveIt() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean rejectIt() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String completeIt() {
		
		m_justPrepared = true;
		this.setDocStatus("CO");
		this.setDocAction(DocAction.ACTION_Close);
		this.setProcessed(true);
		
		return null;
	}

	@Override
	public boolean voidIt() {

		m_justPrepared = true;
		this.setDocStatus(DOCSTATUS_Voided);
		this.setDocAction(DocAction.ACTION_None);
		this.setProcessed(true);
		
		return true;
	}

	@Override
	public boolean closeIt() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reverseCorrectIt() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reverseAccrualIt() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reActivateIt() {
		// TODO Auto-generated method stub
		m_justPrepared = true;
		this.setDocStatus("DR");
		this.setDocAction(DocAction.ACTION_Complete);
		this.setProcessed(false);
		return true;
	}

	@Override
	public String getSummary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDocumentNo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDocumentInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public File createPDF() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProcessMsg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDoc_User_ID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getC_Currency_ID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BigDecimal getApprovalAmt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int customizeValidActions(String docStatus, Object processing, String orderType, String isSOTrx,
			int AD_Table_ID, String[] docAction, String[] options, int index) {

		if (docStatus.equals(DocumentEngine.STATUS_Completed)) {
	   		// 1. Remove all
	   		for (int i = 0; i < options.length; i++) {
	   			options[i] = null;
	   		}
	   		// 2. Add Prepare
	   		options[0] = DocumentEngine.ACTION_ReActivate;
	   		options[1] = DocumentEngine.ACTION_Void;
	   		index = 2;
	   	}
	   	
	   	return index;
	}
}
