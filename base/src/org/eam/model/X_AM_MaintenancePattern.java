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
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;

/** Generated Model for AM_MaintenancePattern
 *  @author Adempiere (generated) 
 *  @version Release 3.9.3 - $Id$ */
public class X_AM_MaintenancePattern extends PO implements I_AM_MaintenancePattern, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200325L;

    /** Standard Constructor */
    public X_AM_MaintenancePattern (Properties ctx, int AM_MaintenancePattern_ID, String trxName)
    {
      super (ctx, AM_MaintenancePattern_ID, trxName);
      /** if (AM_MaintenancePattern_ID == 0)
        {
			setAM_MaintenancePattern_ID (0);
        } */
    }

    /** Load Constructor */
    public X_AM_MaintenancePattern (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_AM_MaintenancePattern[")
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

	/** Set AM Maintenance Pattern.
		@param AM_MaintenancePattern_ID AM Maintenance Pattern	  */
	public void setAM_MaintenancePattern_ID (int AM_MaintenancePattern_ID)
	{
		if (AM_MaintenancePattern_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AM_MaintenancePattern_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AM_MaintenancePattern_ID, Integer.valueOf(AM_MaintenancePattern_ID));
	}

	/** Get AM Maintenance Pattern.
		@return AM Maintenance Pattern	  */
	public int getAM_MaintenancePattern_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AM_MaintenancePattern_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Calculate Cost.
		@param CalculateCost Calculate Cost	  */
	public void setCalculateCost (String CalculateCost)
	{
		set_Value (COLUMNNAME_CalculateCost, CalculateCost);
	}

	/** Get Calculate Cost.
		@return Calculate Cost	  */
	public String getCalculateCost () 
	{
		return (String)get_Value(COLUMNNAME_CalculateCost);
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
		set_Value (COLUMNNAME_CostAmt, CostAmt);
	}

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

	/** MaintenanceArea AD_Reference_ID=53818 */
	public static final int MAINTENANCEAREA_AD_Reference_ID=53818;
	/** Electrical = EL */
	public static final String MAINTENANCEAREA_Electrical = "EL";
	/** General = GE */
	public static final String MAINTENANCEAREA_General = "GE";
	/** Mechanic = ME */
	public static final String MAINTENANCEAREA_Mechanic = "ME";
	/** Refrigeration = RE */
	public static final String MAINTENANCEAREA_Refrigeration = "RE";
	/** Set Maintenance Area.
		@param MaintenanceArea Maintenance Area	  */
	public void setMaintenanceArea (String MaintenanceArea)
	{

		set_Value (COLUMNNAME_MaintenanceArea, MaintenanceArea);
	}

	/** Get Maintenance Area.
		@return Maintenance Area	  */
	public String getMaintenanceArea () 
	{
		return (String)get_Value(COLUMNNAME_MaintenanceArea);
	}

	/** MaintenancePatternType AD_Reference_ID=53817 */
	public static final int MAINTENANCEPATTERNTYPE_AD_Reference_ID=53817;
	/** Type A = AA */
	public static final String MAINTENANCEPATTERNTYPE_TypeA = "AA";
	/** Type B = BB */
	public static final String MAINTENANCEPATTERNTYPE_TypeB = "BB";
	/** Type C = CC */
	public static final String MAINTENANCEPATTERNTYPE_TypeC = "CC";
	/** Set Maintenance Pattern Type.
		@param MaintenancePatternType Maintenance Pattern Type	  */
	public void setMaintenancePatternType (String MaintenancePatternType)
	{

		set_Value (COLUMNNAME_MaintenancePatternType, MaintenancePatternType);
	}

	/** Get Maintenance Pattern Type.
		@return Maintenance Pattern Type	  */
	public String getMaintenancePatternType () 
	{
		return (String)get_Value(COLUMNNAME_MaintenancePatternType);
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

	/** Set Search Key.
		@param Value 
		Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue () 
	{
		return (String)get_Value(COLUMNNAME_Value);
	}
}