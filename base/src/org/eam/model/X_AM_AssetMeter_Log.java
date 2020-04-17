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

/** Generated Model for AM_AssetMeter_Log
 *  @author Adempiere (generated) 
 *  @version Release 3.9.3 - $Id$ */
public class X_AM_AssetMeter_Log extends PO implements I_AM_AssetMeter_Log, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200417L;

    /** Standard Constructor */
    public X_AM_AssetMeter_Log (Properties ctx, int AM_AssetMeter_Log_ID, String trxName)
    {
      super (ctx, AM_AssetMeter_Log_ID, trxName);
      /** if (AM_AssetMeter_Log_ID == 0)
        {
			setAM_AssetMeter_ID (0);
			setAM_AssetMeter_Log_ID (0);
			setDateTrx (new Timestamp( System.currentTimeMillis() ));
        } */
    }

    /** Load Constructor */
    public X_AM_AssetMeter_Log (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_AM_AssetMeter_Log[")
        .append(get_ID()).append("]");
      return sb.toString();
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

	/** Set AM Asset Meter.
		@param AM_AssetMeter_ID AM Asset Meter	  */
	public void setAM_AssetMeter_ID (int AM_AssetMeter_ID)
	{
		if (AM_AssetMeter_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AM_AssetMeter_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AM_AssetMeter_ID, Integer.valueOf(AM_AssetMeter_ID));
	}

	/** Get AM Asset Meter.
		@return AM Asset Meter	  */
	public int getAM_AssetMeter_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AM_AssetMeter_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set AM Asset Meter Log.
		@param AM_AssetMeter_Log_ID AM Asset Meter Log	  */
	public void setAM_AssetMeter_Log_ID (int AM_AssetMeter_Log_ID)
	{
		if (AM_AssetMeter_Log_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AM_AssetMeter_Log_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AM_AssetMeter_Log_ID, Integer.valueOf(AM_AssetMeter_Log_ID));
	}

	/** Get AM Asset Meter Log.
		@return AM Asset Meter Log	  */
	public int getAM_AssetMeter_Log_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AM_AssetMeter_Log_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Amount.
		@param Amt 
		Amount
	  */
	public void setAmt (BigDecimal Amt)
	{
		set_Value (COLUMNNAME_Amt, Amt);
	}

	/** Get Amount.
		@return Amount
	  */
	public BigDecimal getAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Amt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Current Amt.
		@param CurrentAmt Current Amt	  */
	public void setCurrentAmt (BigDecimal CurrentAmt)
	{
		set_Value (COLUMNNAME_CurrentAmt, CurrentAmt);
	}

	/** Get Current Amt.
		@return Current Amt	  */
	public BigDecimal getCurrentAmt () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_CurrentAmt);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Transaction Date.
		@param DateTrx 
		Transaction Date
	  */
	public void setDateTrx (Timestamp DateTrx)
	{
		set_Value (COLUMNNAME_DateTrx, DateTrx);
	}

	/** Get Transaction Date.
		@return Transaction Date
	  */
	public Timestamp getDateTrx () 
	{
		return (Timestamp)get_Value(COLUMNNAME_DateTrx);
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