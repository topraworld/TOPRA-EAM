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

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Model for AM_Meter
 *  @author Adempiere (generated) 
 *  @version Release 3.9.3 - $Id$ */
public class X_AM_Meter extends PO implements I_AM_Meter, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200429L;

    /** Standard Constructor */
    public X_AM_Meter (Properties ctx, int AM_Meter_ID, String trxName)
    {
      super (ctx, AM_Meter_ID, trxName);
      /** if (AM_Meter_ID == 0)
        {
			setAM_Meter_ID (0);
			setName (null);
			setType (null);
// AC
        } */
    }

    /** Load Constructor */
    public X_AM_Meter (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_AM_Meter[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set AM Meter.
		@param AM_Meter_ID AM Meter	  */
	public void setAM_Meter_ID (int AM_Meter_ID)
	{
		if (AM_Meter_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AM_Meter_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AM_Meter_ID, Integer.valueOf(AM_Meter_ID));
	}

	/** Get AM Meter.
		@return AM Meter	  */
	public int getAM_Meter_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AM_Meter_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Max Day.
		@param MaxDay Max Day	  */
	public void setMaxDay (int MaxDay)
	{
		set_Value (COLUMNNAME_MaxDay, Integer.valueOf(MaxDay));
	}

	/** Get Max Day.
		@return Max Day	  */
	public int getMaxDay () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_MaxDay);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Max Records.
		@param MaxRecords Max Records	  */
	public void setMaxRecords (int MaxRecords)
	{
		set_Value (COLUMNNAME_MaxRecords, Integer.valueOf(MaxRecords));
	}

	/** Get Max Records.
		@return Max Records	  */
	public int getMaxRecords () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_MaxRecords);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Min Records.
		@param MinRecords Min Records	  */
	public void setMinRecords (int MinRecords)
	{
		set_Value (COLUMNNAME_MinRecords, Integer.valueOf(MinRecords));
	}

	/** Get Min Records.
		@return Min Records	  */
	public int getMinRecords () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_MinRecords);
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

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), getName());
    }

	/** Type AD_Reference_ID=1000007 */
	public static final int TYPE_AD_Reference_ID=1000007;
	/** Accumulated = AC */
	public static final String TYPE_Accumulated = "AC";
	/** Limit = LM */
	public static final String TYPE_Limit = "LM";
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