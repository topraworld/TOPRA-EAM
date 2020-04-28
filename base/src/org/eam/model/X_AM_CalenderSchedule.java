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

/** Generated Model for AM_CalenderSchedule
 *  @author Adempiere (generated) 
 *  @version Release 3.9.3 - $Id$ */
public class X_AM_CalenderSchedule extends PO implements I_AM_CalenderSchedule, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200428L;

    /** Standard Constructor */
    public X_AM_CalenderSchedule (Properties ctx, int AM_CalenderSchedule_ID, String trxName)
    {
      super (ctx, AM_CalenderSchedule_ID, trxName);
      /** if (AM_CalenderSchedule_ID == 0)
        {
			setAM_CalenderSchedule_ID (0);
        } */
    }

    /** Load Constructor */
    public X_AM_CalenderSchedule (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_AM_CalenderSchedule[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	/** Set AM_CalenderSchedule ID.
		@param AM_CalenderSchedule_ID AM_CalenderSchedule ID	  */
	public void setAM_CalenderSchedule_ID (int AM_CalenderSchedule_ID)
	{
		if (AM_CalenderSchedule_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AM_CalenderSchedule_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AM_CalenderSchedule_ID, Integer.valueOf(AM_CalenderSchedule_ID));
	}

	/** Get AM_CalenderSchedule ID.
		@return AM_CalenderSchedule ID	  */
	public int getAM_CalenderSchedule_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AM_CalenderSchedule_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.eam.model.I_AM_Maintenance getAM_Maintenance() throws RuntimeException
    {
		return (org.eam.model.I_AM_Maintenance)MTable.get(getCtx(), org.eam.model.I_AM_Maintenance.Table_Name)
			.getPO(getAM_Maintenance_ID(), get_TrxName());	}

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

	/** Set Actual Finish Date.
		@param DateActualFinished Actual Finish Date	  */
	public void setDateActualFinished (Timestamp DateActualFinished)
	{
		set_Value (COLUMNNAME_DateActualFinished, DateActualFinished);
	}

	/** Get Actual Finish Date.
		@return Actual Finish Date	  */
	public Timestamp getDateActualFinished () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateActualFinished);
	}

	/** Set Scheduled Date.
		@param DateScheduled Scheduled Date	  */
	public void setDateScheduled (Timestamp DateScheduled)
	{
		set_Value (COLUMNNAME_DateScheduled, DateScheduled);
	}

	/** Get Scheduled Date.
		@return Scheduled Date	  */
	public Timestamp getDateScheduled () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateScheduled);
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

	/** Set Due Percentage %.
		@param DuePercentage Due Percentage %	  */
	public void setDuePercentage (BigDecimal DuePercentage)
	{
		set_Value (COLUMNNAME_DuePercentage, DuePercentage);
	}

	/** Get Due Percentage %.
		@return Due Percentage %	  */
	public BigDecimal getDuePercentage () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_DuePercentage);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Generate Work Order.
		@param IsWOGeneratable Generate Work Order	  */
	public void setIsWOGeneratable (boolean IsWOGeneratable)
	{
		set_Value (COLUMNNAME_IsWOGeneratable, Boolean.valueOf(IsWOGeneratable));
	}

	/** Get Generate Work Order.
		@return Generate Work Order	  */
	public boolean isWOGeneratable () 
	{
		Object oo = get_Value(COLUMNNAME_IsWOGeneratable);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Sequence.
		@param SeqNo 
		Method of ordering records; lowest number comes first
	  */
	public void setSeqNo (int SeqNo)
	{
		set_Value (COLUMNNAME_SeqNo, Integer.valueOf(SeqNo));
	}

	/** Get Sequence.
		@return Method of ordering records; lowest number comes first
	  */
	public int getSeqNo () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_SeqNo);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Status AD_Reference_ID=1000004 */
	public static final int STATUS_AD_Reference_ID=1000004;
	/** Open = OP */
	public static final String STATUS_Open = "OP";
	/** In Progress = IN */
	public static final String STATUS_InProgress = "IN";
	/** Done = DO */
	public static final String STATUS_Done = "DO";
	/** Skipped = SK */
	public static final String STATUS_Skipped = "SK";
	/** Set Status.
		@param Status 
		Status of the currently running check
	  */
	public void setStatus (String Status)
	{

		set_Value (COLUMNNAME_Status, Status);
	}

	/** Get Status.
		@return Status of the currently running check
	  */
	public String getStatus () 
	{
		return (String)get_Value(COLUMNNAME_Status);
	}

	/** Type AD_Reference_ID=1000006 */
	public static final int TYPE_AD_Reference_ID=1000006;
	/** Calander = C */
	public static final String TYPE_Calander = "C";
	/** Meter = M */
	public static final String TYPE_Meter = "M";
	/** Set Type.
		@param Type 
		Type of Validation (SQL, Java Script, Java Language)
	  */
	public void setType (String Type)
	{

		set_Value (COLUMNNAME_Type, Type);
	}

	/** Get Type.
		@return Type of Validation (SQL, Java Script, Java Language)
	  */
	public String getType () 
	{
		return (String)get_Value(COLUMNNAME_Type);
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
}