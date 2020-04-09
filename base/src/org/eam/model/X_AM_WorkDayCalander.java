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
import java.sql.Timestamp;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for AM_WorkDayCalander
 *  @author Adempiere (generated) 
 *  @version Release 3.9.3 - $Id$ */
public class X_AM_WorkDayCalander extends PO implements I_AM_WorkDayCalander, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200409L;

    /** Standard Constructor */
    public X_AM_WorkDayCalander (Properties ctx, int AM_WorkDayCalander_ID, String trxName)
    {
      super (ctx, AM_WorkDayCalander_ID, trxName);
      /** if (AM_WorkDayCalander_ID == 0)
        {
			setAM_WorkDayCalander_ID (0);
			setDate1 (new Timestamp( System.currentTimeMillis() ));
			setWeekDay (null);
        } */
    }

    /** Load Constructor */
    public X_AM_WorkDayCalander (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_AM_WorkDayCalander[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set AM_WorkDayCalander ID.
		@param AM_WorkDayCalander_ID AM_WorkDayCalander ID	  */
	public void setAM_WorkDayCalander_ID (int AM_WorkDayCalander_ID)
	{
		if (AM_WorkDayCalander_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AM_WorkDayCalander_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AM_WorkDayCalander_ID, Integer.valueOf(AM_WorkDayCalander_ID));
	}

	/** Get AM_WorkDayCalander ID.
		@return AM_WorkDayCalander ID	  */
	public int getAM_WorkDayCalander_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AM_WorkDayCalander_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Period getC_Period() throws RuntimeException
    {
		return (org.compiere.model.I_C_Period)MTable.get(getCtx(), org.compiere.model.I_C_Period.Table_Name)
			.getPO(getC_Period_ID(), get_TrxName());	}

	/** Set Period.
		@param C_Period_ID 
		Period of the Calendar
	  */
	public void setC_Period_ID (int C_Period_ID)
	{
		if (C_Period_ID < 1) 
			set_Value (COLUMNNAME_C_Period_ID, null);
		else 
			set_Value (COLUMNNAME_C_Period_ID, Integer.valueOf(C_Period_ID));
	}

	/** Get Period.
		@return Period of the Calendar
	  */
	public int getC_Period_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Period_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_Year getC_Year() throws RuntimeException
    {
		return (org.compiere.model.I_C_Year)MTable.get(getCtx(), org.compiere.model.I_C_Year.Table_Name)
			.getPO(getC_Year_ID(), get_TrxName());	}

	/** Set Year.
		@param C_Year_ID 
		Calendar Year
	  */
	public void setC_Year_ID (int C_Year_ID)
	{
		if (C_Year_ID < 1) 
			set_Value (COLUMNNAME_C_Year_ID, null);
		else 
			set_Value (COLUMNNAME_C_Year_ID, Integer.valueOf(C_Year_ID));
	}

	/** Get Year.
		@return Calendar Year
	  */
	public int getC_Year_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_Year_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Date.
		@param Date1 
		Date when business is not conducted
	  */
	public void setDate1 (Timestamp Date1)
	{
		set_Value (COLUMNNAME_Date1, Date1);
	}

	/** Get Date.
		@return Date when business is not conducted
	  */
	public Timestamp getDate1 () 
	{
		return (Timestamp)get_Value(COLUMNNAME_Date1);
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

	/** Set Working Day.
		@param IsWorkingDay Working Day	  */
	public void setIsWorkingDay (boolean IsWorkingDay)
	{
		set_Value (COLUMNNAME_IsWorkingDay, Boolean.valueOf(IsWorkingDay));
	}

	/** Get Working Day.
		@return Working Day	  */
	public boolean isWorkingDay () 
	{
		Object oo = get_Value(COLUMNNAME_IsWorkingDay);
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

	/** WeekDay AD_Reference_ID=1000005 */
	public static final int WEEKDAY_AD_Reference_ID=1000005;
	/** Sunday = 1 */
	public static final String WEEKDAY_Sunday = "1";
	/** Monday = 2 */
	public static final String WEEKDAY_Monday = "2";
	/** Tuesday = 3 */
	public static final String WEEKDAY_Tuesday = "3";
	/** Wednesday = 4 */
	public static final String WEEKDAY_Wednesday = "4";
	/** Thursday = 5 */
	public static final String WEEKDAY_Thursday = "5";
	/** Friday = 6 */
	public static final String WEEKDAY_Friday = "6";
	/** Saturday = 7 */
	public static final String WEEKDAY_Saturday = "7";
	/** Set Day of the Week.
		@param WeekDay 
		Day of the Week
	  */
	public void setWeekDay (String WeekDay)
	{

		set_Value (COLUMNNAME_WeekDay, WeekDay);
	}

	/** Get Day of the Week.
		@return Day of the Week
	  */
	public String getWeekDay () 
	{
		return (String)get_Value(COLUMNNAME_WeekDay);
	}
}