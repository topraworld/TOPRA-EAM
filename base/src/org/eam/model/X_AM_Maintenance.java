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
/** Generated Model - DO NOT CHANGE */
package org.eam.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;

/** Generated Model for AM_Maintenance
 *  @author Adempiere (generated) 
 *  @version Release 3.9.3 - $Id$ */
public class X_AM_Maintenance extends PO implements I_AM_Maintenance, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200509L;

    /** Standard Constructor */
    public X_AM_Maintenance (Properties ctx, int AM_Maintenance_ID, String trxName)
    {
      super (ctx, AM_Maintenance_ID, trxName);
      /** if (AM_Maintenance_ID == 0)
        {
			setAM_Maintenance_ID (0);
			setAM_PatternType_ID (0);
			setC_DocType_ID (0);
// 1000060
			setDateDoc (new Timestamp( System.currentTimeMillis() ));
// @#Date@
			setDocAction (null);
// PR
			setDocStatus (null);
// DR
			setDocumentNo (null);
			setIsApproved (false);
// N
			setLeadTime (0);
// 14
			setM_PriceList_ID (0);
// 1000001
			setPriorityRule (null);
			setProcessed (false);
// N
			setProcessing (false);
// N
			setValidFrom (new Timestamp( System.currentTimeMillis() ));
			setValidTo (new Timestamp( System.currentTimeMillis() ));
        } */
    }

    /** Load Constructor */
    public X_AM_Maintenance (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_AM_Maintenance[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.compiere.model.I_A_Asset_Group getA_Asset_Group() throws RuntimeException
    {
		return (org.compiere.model.I_A_Asset_Group)MTable.get(getCtx(), org.compiere.model.I_A_Asset_Group.Table_Name)
			.getPO(getA_Asset_Group_ID(), get_TrxName());	}

	/** Set Asset Group.
		@param A_Asset_Group_ID 
		Group of Assets
	  */
	public void setA_Asset_Group_ID (int A_Asset_Group_ID)
	{
		if (A_Asset_Group_ID < 1) 
			set_Value (COLUMNNAME_A_Asset_Group_ID, null);
		else 
			set_Value (COLUMNNAME_A_Asset_Group_ID, Integer.valueOf(A_Asset_Group_ID));
	}

	/** Get Asset Group.
		@return Group of Assets
	  */
	public int getA_Asset_Group_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_A_Asset_Group_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_A_Asset getA_Asset() throws RuntimeException
    {
		return (org.compiere.model.I_A_Asset)MTable.get(getCtx(), org.compiere.model.I_A_Asset.Table_Name)
			.getPO(getA_Asset_ID(), get_TrxName());	}

	/** Set Fixed Asset.
		@param A_Asset_ID 
		Fixed Asset used internally or by customers
	  */
	public void setA_Asset_ID (int A_Asset_ID)
	{
		if (A_Asset_ID < 1) 
			set_Value (COLUMNNAME_A_Asset_ID, null);
		else 
			set_Value (COLUMNNAME_A_Asset_ID, Integer.valueOf(A_Asset_ID));
	}

	/** Get Fixed Asset.
		@return Fixed Asset used internally or by customers
	  */
	public int getA_Asset_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_A_Asset_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_AD_User getAD_User() throws RuntimeException
    {
		return (org.compiere.model.I_AD_User)MTable.get(getCtx(), org.compiere.model.I_AD_User.Table_Name)
			.getPO(getAD_User_ID(), get_TrxName());	}

	/** Set User/Contact.
		@param AD_User_ID 
		User within the system - Internal or Business Partner Contact
	  */
	public void setAD_User_ID (int AD_User_ID)
	{
		if (AD_User_ID < 1) 
			set_Value (COLUMNNAME_AD_User_ID, null);
		else 
			set_Value (COLUMNNAME_AD_User_ID, Integer.valueOf(AD_User_ID));
	}

	/** Get User/Contact.
		@return User within the system - Internal or Business Partner Contact
	  */
	public int getAD_User_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_User_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set AM Maintenance.
		@param AM_Maintenance_ID AM Maintenance	  */
	public void setAM_Maintenance_ID (int AM_Maintenance_ID)
	{
		if (AM_Maintenance_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AM_Maintenance_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AM_Maintenance_ID, Integer.valueOf(AM_Maintenance_ID));
	}

	/** Get AM Maintenance.
		@return AM Maintenance	  */
	public int getAM_Maintenance_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AM_Maintenance_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.eam.model.I_AM_MaintenanceArea getAM_MaintenanceArea() throws RuntimeException
    {
		return (org.eam.model.I_AM_MaintenanceArea)MTable.get(getCtx(), org.eam.model.I_AM_MaintenanceArea.Table_Name)
			.getPO(getAM_MaintenanceArea_ID(), get_TrxName());	}

	/** Set AM_MaintenanceArea ID.
		@param AM_MaintenanceArea_ID AM_MaintenanceArea ID	  */
	public void setAM_MaintenanceArea_ID (int AM_MaintenanceArea_ID)
	{
		if (AM_MaintenanceArea_ID < 1) 
			set_Value (COLUMNNAME_AM_MaintenanceArea_ID, null);
		else 
			set_Value (COLUMNNAME_AM_MaintenanceArea_ID, Integer.valueOf(AM_MaintenanceArea_ID));
	}

	/** Get AM_MaintenanceArea ID.
		@return AM_MaintenanceArea ID	  */
	public int getAM_MaintenanceArea_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AM_MaintenanceArea_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.eam.model.I_AM_Maintenance getAM_MaintenanceParent() throws RuntimeException
    {
		return (org.eam.model.I_AM_Maintenance)MTable.get(getCtx(), org.eam.model.I_AM_Maintenance.Table_Name)
			.getPO(getAM_MaintenanceParent_ID(), get_TrxName());	}

	/** Set AM Maintenance Parent.
		@param AM_MaintenanceParent_ID AM Maintenance Parent	  */
	public void setAM_MaintenanceParent_ID (int AM_MaintenanceParent_ID)
	{
		if (AM_MaintenanceParent_ID < 1) 
			set_Value (COLUMNNAME_AM_MaintenanceParent_ID, null);
		else 
			set_Value (COLUMNNAME_AM_MaintenanceParent_ID, Integer.valueOf(AM_MaintenanceParent_ID));
	}

	/** Get AM Maintenance Parent.
		@return AM Maintenance Parent	  */
	public int getAM_MaintenanceParent_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AM_MaintenanceParent_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.eam.model.I_AM_MaintenancePattern getAM_MaintenancePatern() throws RuntimeException
    {
		return (org.eam.model.I_AM_MaintenancePattern)MTable.get(getCtx(), org.eam.model.I_AM_MaintenancePattern.Table_Name)
			.getPO(getAM_MaintenancePatern_ID(), get_TrxName());	}

	/** Set AM_MaintenancePatern ID.
		@param AM_MaintenancePatern_ID AM_MaintenancePatern ID	  */
	public void setAM_MaintenancePatern_ID (int AM_MaintenancePatern_ID)
	{
		if (AM_MaintenancePatern_ID < 1) 
			set_Value (COLUMNNAME_AM_MaintenancePatern_ID, null);
		else 
			set_Value (COLUMNNAME_AM_MaintenancePatern_ID, Integer.valueOf(AM_MaintenancePatern_ID));
	}

	/** Get AM_MaintenancePatern ID.
		@return AM_MaintenancePatern ID	  */
	public int getAM_MaintenancePatern_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AM_MaintenancePatern_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.eam.model.I_AM_Meter getAM_Meter() throws RuntimeException
    {
		return (org.eam.model.I_AM_Meter)MTable.get(getCtx(), org.eam.model.I_AM_Meter.Table_Name)
			.getPO(getAM_Meter_ID(), get_TrxName());	}

	/** Set Meter.
		@param AM_Meter_ID Meter	  */
	public void setAM_Meter_ID (int AM_Meter_ID)
	{
		if (AM_Meter_ID < 1) 
			set_Value (COLUMNNAME_AM_Meter_ID, null);
		else 
			set_Value (COLUMNNAME_AM_Meter_ID, Integer.valueOf(AM_Meter_ID));
	}

	/** Get Meter.
		@return Meter	  */
	public int getAM_Meter_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AM_Meter_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.eam.model.I_AM_PatternType getAM_PatternType() throws RuntimeException
    {
		return (org.eam.model.I_AM_PatternType)MTable.get(getCtx(), org.eam.model.I_AM_PatternType.Table_Name)
			.getPO(getAM_PatternType_ID(), get_TrxName());	}

	/** Set AM_PatternType ID.
		@param AM_PatternType_ID AM_PatternType ID	  */
	public void setAM_PatternType_ID (int AM_PatternType_ID)
	{
		if (AM_PatternType_ID < 1) 
			set_Value (COLUMNNAME_AM_PatternType_ID, null);
		else 
			set_Value (COLUMNNAME_AM_PatternType_ID, Integer.valueOf(AM_PatternType_ID));
	}

	/** Get AM_PatternType ID.
		@return AM_PatternType ID	  */
	public int getAM_PatternType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AM_PatternType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_DocType getC_DocType() throws RuntimeException
    {
		return (org.compiere.model.I_C_DocType)MTable.get(getCtx(), org.compiere.model.I_C_DocType.Table_Name)
			.getPO(getC_DocType_ID(), get_TrxName());	}

	/** Set Document Type.
		@param C_DocType_ID 
		Document type or rules
	  */
	public void setC_DocType_ID (int C_DocType_ID)
	{
		if (C_DocType_ID < 0) 
			set_Value (COLUMNNAME_C_DocType_ID, null);
		else 
			set_Value (COLUMNNAME_C_DocType_ID, Integer.valueOf(C_DocType_ID));
	}

	/** Get Document Type.
		@return Document type or rules
	  */
	public int getC_DocType_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_DocType_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Interval.
		@param CBInterval Interval	  */
	public void setCBInterval (BigDecimal CBInterval)
	{
		set_Value (COLUMNNAME_CBInterval, CBInterval);
	}

	/** Get Interval.
		@return Interval	  */
	public BigDecimal getCBInterval () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_CBInterval);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** CBTimeUnit AD_Reference_ID=53376 */
	public static final int CBTIMEUNIT_AD_Reference_ID=53376;
	/** Day = D */
	public static final String CBTIMEUNIT_Day = "D";
	/** Week = W */
	public static final String CBTIMEUNIT_Week = "W";
	/** Month = M */
	public static final String CBTIMEUNIT_Month = "M";
	/** Quarter = Q */
	public static final String CBTIMEUNIT_Quarter = "Q";
	/** Year = Y */
	public static final String CBTIMEUNIT_Year = "Y";
	/** Hour = H */
	public static final String CBTIMEUNIT_Hour = "H";
	/** Minute = I */
	public static final String CBTIMEUNIT_Minute = "I";
	/** Set Time Unit.
		@param CBTimeUnit 
		The unit of time for grouping chart data.
	  */
	public void setCBTimeUnit (String CBTimeUnit)
	{

		set_Value (COLUMNNAME_CBTimeUnit, CBTimeUnit);
	}

	/** Get Time Unit.
		@return The unit of time for grouping chart data.
	  */
	public String getCBTimeUnit () 
	{
		return (String)get_Value(COLUMNNAME_CBTimeUnit);
	}

	/** Set Copy From.
		@param CopyFrom 
		Copy From Record
	  */
	public void setCopyFrom (String CopyFrom)
	{
		set_Value (COLUMNNAME_CopyFrom, CopyFrom);
	}

	/** Get Copy From.
		@return Copy From Record
	  */
	public String getCopyFrom () 
	{
		return (String)get_Value(COLUMNNAME_CopyFrom);
	}

	/** Set Cost Value.
		@param CostAmt 
		Value with Cost
	  */
	public void setCostAmt (BigDecimal CostAmt)
	{
		throw new IllegalArgumentException ("CostAmt is virtual column");	}

	/** Get Cost Value.
		@return Value with Cost
	  */
	public BigDecimal getCostAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_CostAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set CurrentAM.
		@param CurrentAM CurrentAM	  */
	public void setCurrentAM (BigDecimal CurrentAM)
	{
		set_Value (COLUMNNAME_CurrentAM, CurrentAM);
	}

	/** Get CurrentAM.
		@return CurrentAM	  */
	public BigDecimal getCurrentAM () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_CurrentAM);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Document Date.
		@param DateDoc 
		Date of the Document
	  */
	public void setDateDoc (Timestamp DateDoc)
	{
		set_Value (COLUMNNAME_DateDoc, DateDoc);
	}

	/** Get Document Date.
		@return Date of the Document
	  */
	public Timestamp getDateDoc () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateDoc);
	}

	/** Set Date last run.
		@param DateLastRun 
		Date the process was last run.
	  */
	public void setDateLastRun (Timestamp DateLastRun)
	{
		set_Value (COLUMNNAME_DateLastRun, DateLastRun);
	}

	/** Get Date last run.
		@return Date the process was last run.
	  */
	public Timestamp getDateLastRun () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateLastRun);
	}

	/** Set Date Last Run AM.
		@param DateLastRunAM Date Last Run AM	  */
	public void setDateLastRunAM (Timestamp DateLastRunAM)
	{
		set_Value (COLUMNNAME_DateLastRunAM, DateLastRunAM);
	}

	/** Get Date Last Run AM.
		@return Date Last Run AM	  */
	public Timestamp getDateLastRunAM () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateLastRunAM);
	}

	/** Set Date Last Service Order.
		@param DateLastSO Date Last Service Order	  */
	public void setDateLastSO (Timestamp DateLastSO)
	{
		set_Value (COLUMNNAME_DateLastSO, DateLastSO);
	}

	/** Get Date Last Service Order.
		@return Date Last Service Order	  */
	public Timestamp getDateLastSO () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateLastSO);
	}

	/** Set Date next run.
		@param DateNextRun 
		Date the process will run next
	  */
	public void setDateNextRun (Timestamp DateNextRun)
	{
		set_Value (COLUMNNAME_DateNextRun, DateNextRun);
	}

	/** Get Date next run.
		@return Date the process will run next
	  */
	public Timestamp getDateNextRun () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateNextRun);
	}

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

	/** DocAction AD_Reference_ID=135 */
	public static final int DOCACTION_AD_Reference_ID=135;
	/** Complete = CO */
	public static final String DOCACTION_Complete = "CO";
	/** Approve = AP */
	public static final String DOCACTION_Approve = "AP";
	/** Reject = RJ */
	public static final String DOCACTION_Reject = "RJ";
	/** Post = PO */
	public static final String DOCACTION_Post = "PO";
	/** Void = VO */
	public static final String DOCACTION_Void = "VO";
	/** Close = CL */
	public static final String DOCACTION_Close = "CL";
	/** Reverse - Correct = RC */
	public static final String DOCACTION_Reverse_Correct = "RC";
	/** Reverse - Accrual = RA */
	public static final String DOCACTION_Reverse_Accrual = "RA";
	/** Invalidate = IN */
	public static final String DOCACTION_Invalidate = "IN";
	/** Re-activate = RE */
	public static final String DOCACTION_Re_Activate = "RE";
	/** <None> = -- */
	public static final String DOCACTION_None = "--";
	/** Prepare = PR */
	public static final String DOCACTION_Prepare = "PR";
	/** Unlock = XL */
	public static final String DOCACTION_Unlock = "XL";
	/** Wait Complete = WC */
	public static final String DOCACTION_WaitComplete = "WC";
	/** Set Document Action.
		@param DocAction 
		The targeted status of the document
	  */
	public void setDocAction (String DocAction)
	{

		set_Value (COLUMNNAME_DocAction, DocAction);
	}

	/** Get Document Action.
		@return The targeted status of the document
	  */
	public String getDocAction () 
	{
		return (String)get_Value(COLUMNNAME_DocAction);
	}

	/** DocStatus AD_Reference_ID=131 */
	public static final int DOCSTATUS_AD_Reference_ID=131;
	/** Drafted = DR */
	public static final String DOCSTATUS_Drafted = "DR";
	/** Completed = CO */
	public static final String DOCSTATUS_Completed = "CO";
	/** Approved = AP */
	public static final String DOCSTATUS_Approved = "AP";
	/** Not Approved = NA */
	public static final String DOCSTATUS_NotApproved = "NA";
	/** Voided = VO */
	public static final String DOCSTATUS_Voided = "VO";
	/** Invalid = IN */
	public static final String DOCSTATUS_Invalid = "IN";
	/** Reversed = RE */
	public static final String DOCSTATUS_Reversed = "RE";
	/** Closed = CL */
	public static final String DOCSTATUS_Closed = "CL";
	/** Unknown = ?? */
	public static final String DOCSTATUS_Unknown = "??";
	/** In Progress = IP */
	public static final String DOCSTATUS_InProgress = "IP";
	/** Waiting Payment = WP */
	public static final String DOCSTATUS_WaitingPayment = "WP";
	/** Waiting Confirmation = WC */
	public static final String DOCSTATUS_WaitingConfirmation = "WC";
	/** Set Document Status.
		@param DocStatus 
		The current status of the document
	  */
	public void setDocStatus (String DocStatus)
	{

		set_Value (COLUMNNAME_DocStatus, DocStatus);
	}

	/** Get Document Status.
		@return The current status of the document
	  */
	public String getDocStatus () 
	{
		return (String)get_Value(COLUMNNAME_DocStatus);
	}

	/** Set Document No.
		@param DocumentNo 
		Document sequence number of the document
	  */
	public void setDocumentNo (String DocumentNo)
	{
		set_Value (COLUMNNAME_DocumentNo, DocumentNo);
	}

	/** Get Document No.
		@return Document sequence number of the document
	  */
	public String getDocumentNo () 
	{
		return (String)get_Value(COLUMNNAME_DocumentNo);
	}

	/** Set Approved.
		@param IsApproved 
		Indicates if this document requires approval
	  */
	public void setIsApproved (boolean IsApproved)
	{
		set_Value (COLUMNNAME_IsApproved, Boolean.valueOf(IsApproved));
	}

	/** Get Approved.
		@return Indicates if this document requires approval
	  */
	public boolean isApproved () 
	{
		Object oo = get_Value(COLUMNNAME_IsApproved);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Child.
		@param IsChild Child	  */
	public void setIsChild (boolean IsChild)
	{
		set_Value (COLUMNNAME_IsChild, Boolean.valueOf(IsChild));
	}

	/** Get Child.
		@return Child	  */
	public boolean isChild () 
	{
		Object oo = get_Value(COLUMNNAME_IsChild);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Last AM.
		@param LastAM Last AM	  */
	public void setLastAM (BigDecimal LastAM)
	{
		set_Value (COLUMNNAME_LastAM, LastAM);
	}

	/** Get Last AM.
		@return Last AM	  */
	public BigDecimal getLastAM () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LastAM);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Last Read.
		@param LastRead Last Read	  */
	public void setLastRead (BigDecimal LastRead)
	{
		set_Value (COLUMNNAME_LastRead, LastRead);
	}

	/** Get Last Read.
		@return Last Read	  */
	public BigDecimal getLastRead () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_LastRead);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set LeadTime (Days).
		@param LeadTime LeadTime (Days)	  */
	public void setLeadTime (int LeadTime)
	{
		set_Value (COLUMNNAME_LeadTime, Integer.valueOf(LeadTime));
	}

	/** Get LeadTime (Days).
		@return LeadTime (Days)	  */
	public int getLeadTime () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LeadTime);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_M_PriceList getM_PriceList() throws RuntimeException
    {
		return (org.compiere.model.I_M_PriceList)MTable.get(getCtx(), org.compiere.model.I_M_PriceList.Table_Name)
			.getPO(getM_PriceList_ID(), get_TrxName());	}

	/** Set Price List.
		@param M_PriceList_ID 
		Unique identifier of a Price List
	  */
	public void setM_PriceList_ID (int M_PriceList_ID)
	{
		if (M_PriceList_ID < 1) 
			set_Value (COLUMNNAME_M_PriceList_ID, null);
		else 
			set_Value (COLUMNNAME_M_PriceList_ID, Integer.valueOf(M_PriceList_ID));
	}

	/** Get Price List.
		@return Unique identifier of a Price List
	  */
	public int getM_PriceList_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_PriceList_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Interval.
		@param MBInterval Interval	  */
	public void setMBInterval (BigDecimal MBInterval)
	{
		set_Value (COLUMNNAME_MBInterval, MBInterval);
	}

	/** Get Interval.
		@return Interval	  */
	public BigDecimal getMBInterval () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_MBInterval);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Start Value.
		@param MBStartValue Start Value	  */
	public void setMBStartValue (int MBStartValue)
	{
		set_Value (COLUMNNAME_MBStartValue, Integer.valueOf(MBStartValue));
	}

	/** Get Start Value.
		@return Start Value	  */
	public int getMBStartValue () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_MBStartValue);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	  */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

	/** Set Perform Date Base.
		@param PerformDateBase Perform Date Base	  */
	public void setPerformDateBase (boolean PerformDateBase)
	{
		set_Value (COLUMNNAME_PerformDateBase, Boolean.valueOf(PerformDateBase));
	}

	/** Get Perform Date Base.
		@return Perform Date Base	  */
	public boolean isPerformDateBase () 
	{
		Object oo = get_Value(COLUMNNAME_PerformDateBase);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Perform Value Base.
		@param PerformValueBase Perform Value Base	  */
	public void setPerformValueBase (boolean PerformValueBase)
	{
		set_Value (COLUMNNAME_PerformValueBase, Boolean.valueOf(PerformValueBase));
	}

	/** Get Perform Value Base.
		@return Perform Value Base	  */
	public boolean isPerformValueBase () 
	{
		Object oo = get_Value(COLUMNNAME_PerformValueBase);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** PriorityRule AD_Reference_ID=154 */
	public static final int PRIORITYRULE_AD_Reference_ID=154;
	/** High = 3 */
	public static final String PRIORITYRULE_High = "3";
	/** Medium = 5 */
	public static final String PRIORITYRULE_Medium = "5";
	/** Low = 7 */
	public static final String PRIORITYRULE_Low = "7";
	/** Urgent = 1 */
	public static final String PRIORITYRULE_Urgent = "1";
	/** Minor = 9 */
	public static final String PRIORITYRULE_Minor = "9";
	/** Set Priority.
		@param PriorityRule 
		Priority of a document
	  */
	public void setPriorityRule (String PriorityRule)
	{

		set_Value (COLUMNNAME_PriorityRule, PriorityRule);
	}

	/** Get Priority.
		@return Priority of a document
	  */
	public String getPriorityRule () 
	{
		return (String)get_Value(COLUMNNAME_PriorityRule);
	}

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed () 
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Process Now.
		@param Processing Process Now	  */
	public void setProcessing (boolean Processing)
	{
		set_Value (COLUMNNAME_Processing, Boolean.valueOf(Processing));
	}

	/** Get Process Now.
		@return Process Now	  */
	public boolean isProcessing () 
	{
		Object oo = get_Value(COLUMNNAME_Processing);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Immutable Universally Unique Identifier.
		@param UUID 
		Immutable Universally Unique Identifier
	  */
	public void setUUID (String UUID)
	{
		set_Value (COLUMNNAME_UUID, UUID);
	}

	/** Get Immutable Universally Unique Identifier.
		@return Immutable Universally Unique Identifier
	  */
	public String getUUID () 
	{
		return (String)get_Value(COLUMNNAME_UUID);
	}

	/** Set Valid from.
		@param ValidFrom 
		Valid from including this date (first day)
	  */
	public void setValidFrom (Timestamp ValidFrom)
	{
		set_Value (COLUMNNAME_ValidFrom, ValidFrom);
	}

	/** Get Valid from.
		@return Valid from including this date (first day)
	  */
	public Timestamp getValidFrom () 
	{
		return (Timestamp)get_Value(COLUMNNAME_ValidFrom);
	}

	/** Set Valid to.
		@param ValidTo 
		Valid to including this date (last day)
	  */
	public void setValidTo (Timestamp ValidTo)
	{
		set_Value (COLUMNNAME_ValidTo, ValidTo);
	}

	/** Get Valid to.
		@return Valid to including this date (last day)
	  */
	public Timestamp getValidTo () 
	{
		return (Timestamp)get_Value(COLUMNNAME_ValidTo);
	}
}