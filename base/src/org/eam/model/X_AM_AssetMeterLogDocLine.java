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

/** Generated Model for AM_AssetMeterLogDocLine
 *  @author Adempiere (generated) 
 *  @version Release 3.9.3 - $Id$ */
public class X_AM_AssetMeterLogDocLine extends PO implements I_AM_AssetMeterLogDocLine, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200417L;

    /** Standard Constructor */
    public X_AM_AssetMeterLogDocLine (Properties ctx, int AM_AssetMeterLogDocLine_ID, String trxName)
    {
      super (ctx, AM_AssetMeterLogDocLine_ID, trxName);
      /** if (AM_AssetMeterLogDocLine_ID == 0)
        {
			setA_Asset_ID (0);
			setAM_AssetMeterLogDocLine_ID (0);
			setAM_Meter_ID (0);
			setReading (Env.ZERO);
        } */
    }

    /** Load Constructor */
    public X_AM_AssetMeterLogDocLine (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_AM_AssetMeterLogDocLine[")
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

	public org.eam.model.I_AM_AssetMeter getAM_AssetMeter() throws RuntimeException
    {
		return (org.eam.model.I_AM_AssetMeter)MTable.get(getCtx(), org.eam.model.I_AM_AssetMeter.Table_Name)
			.getPO(getAM_AssetMeter_ID(), get_TrxName());	}

	/** Set AM Asset Meter.
		@param AM_AssetMeter_ID AM Asset Meter	  */
	public void setAM_AssetMeter_ID (int AM_AssetMeter_ID)
	{
		if (AM_AssetMeter_ID < 1) 
			set_Value (COLUMNNAME_AM_AssetMeter_ID, null);
		else 
			set_Value (COLUMNNAME_AM_AssetMeter_ID, Integer.valueOf(AM_AssetMeter_ID));
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
			set_Value (COLUMNNAME_AM_AssetMeter_Log_ID, null);
		else 
			set_Value (COLUMNNAME_AM_AssetMeter_Log_ID, Integer.valueOf(AM_AssetMeter_Log_ID));
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

	/** Set AM_AssetMeterLogDoc ID.
		@param AM_AssetMeterLogDoc_ID AM_AssetMeterLogDoc ID	  */
	public void setAM_AssetMeterLogDoc_ID (int AM_AssetMeterLogDoc_ID)
	{
		if (AM_AssetMeterLogDoc_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AM_AssetMeterLogDoc_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AM_AssetMeterLogDoc_ID, Integer.valueOf(AM_AssetMeterLogDoc_ID));
	}

	/** Get AM_AssetMeterLogDoc ID.
		@return AM_AssetMeterLogDoc ID	  */
	public int getAM_AssetMeterLogDoc_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AM_AssetMeterLogDoc_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set AM_AssetMeterLogDocLine ID.
		@param AM_AssetMeterLogDocLine_ID AM_AssetMeterLogDocLine ID	  */
	public void setAM_AssetMeterLogDocLine_ID (int AM_AssetMeterLogDocLine_ID)
	{
		if (AM_AssetMeterLogDocLine_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AM_AssetMeterLogDocLine_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AM_AssetMeterLogDocLine_ID, Integer.valueOf(AM_AssetMeterLogDocLine_ID));
	}

	/** Get AM_AssetMeterLogDocLine ID.
		@return AM_AssetMeterLogDocLine ID	  */
	public int getAM_AssetMeterLogDocLine_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AM_AssetMeterLogDocLine_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.eam.model.I_AM_Meter getAM_Meter() throws RuntimeException
    {
		return (org.eam.model.I_AM_Meter)MTable.get(getCtx(), org.eam.model.I_AM_Meter.Table_Name)
			.getPO(getAM_Meter_ID(), get_TrxName());	}

	/** Set AM Meter.
		@param AM_Meter_ID AM Meter	  */
	public void setAM_Meter_ID (int AM_Meter_ID)
	{
		if (AM_Meter_ID < 1) 
			set_Value (COLUMNNAME_AM_Meter_ID, null);
		else 
			set_Value (COLUMNNAME_AM_Meter_ID, Integer.valueOf(AM_Meter_ID));
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

	/** Set Line No.
		@param Line 
		Unique line for this document
	  */
	public void setLine (int Line)
	{
		set_Value (COLUMNNAME_Line, Integer.valueOf(Line));
	}

	/** Get Line No.
		@return Unique line for this document
	  */
	public int getLine () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Line);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Reading.
		@param Reading Reading	  */
	public void setReading (BigDecimal Reading)
	{
		set_Value (COLUMNNAME_Reading, Reading);
	}

	/** Get Reading.
		@return Reading	  */
	public BigDecimal getReading () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Reading);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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