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

/** Generated Model for AM_MaintenanceCalender
 *  @author Adempiere (generated) 
 *  @version Release 3.9.3 - $Id$ */
public class X_AM_MaintenanceCalender extends PO implements I_AM_MaintenanceCalender, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200409L;

    /** Standard Constructor */
    public X_AM_MaintenanceCalender (Properties ctx, int AM_MaintenanceCalender_ID, String trxName)
    {
      super (ctx, AM_MaintenanceCalender_ID, trxName);
      /** if (AM_MaintenanceCalender_ID == 0)
        {
			setAM_MaintenanceCalender_ID (0);
			setEndDate (new Timestamp( System.currentTimeMillis() ));
// @SQL=SELECT ValidTo FROM AM_Maintenance WHERE AM_Maintenance_ID=@AM_Maintenance_ID@
			setInterval (Env.ZERO);
// 1
			setStartDate (new Timestamp( System.currentTimeMillis() ));
// @SQL=SELECT ValidFrom FROM AM_Maintenance WHERE AM_Maintenance_ID=@AM_Maintenance_ID@
			setTimeUnit (null);
        } */
    }

    /** Load Constructor */
    public X_AM_MaintenanceCalender (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_AM_MaintenanceCalender[")
        .append(get_ID()).append("]");
      return sb.toString();
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
			set_Value (COLUMNNAME_AM_Maintenance_ID, null);
		else 
			set_Value (COLUMNNAME_AM_Maintenance_ID, Integer.valueOf(AM_Maintenance_ID));
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

	/** Set AM_MaintenanceCalender ID.
		@param AM_MaintenanceCalender_ID AM_MaintenanceCalender ID	  */
	public void setAM_MaintenanceCalender_ID (int AM_MaintenanceCalender_ID)
	{
		if (AM_MaintenanceCalender_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AM_MaintenanceCalender_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AM_MaintenanceCalender_ID, Integer.valueOf(AM_MaintenanceCalender_ID));
	}

	/** Get AM_MaintenanceCalender ID.
		@return AM_MaintenanceCalender ID	  */
	public int getAM_MaintenanceCalender_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AM_MaintenanceCalender_ID);
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

	/** Set End Date.
		@param EndDate 
		Last effective date (inclusive)
	  */
	public void setEndDate (Timestamp EndDate)
	{
		set_Value (COLUMNNAME_EndDate, EndDate);
	}

	/** Get End Date.
		@return Last effective date (inclusive)
	  */
	public Timestamp getEndDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_EndDate);
	}

	/** Set Interval.
		@param Interval Interval	  */
	public void setInterval (BigDecimal Interval)
	{
		set_Value (COLUMNNAME_Interval, Interval);
	}

	/** Get Interval.
		@return Interval	  */
	public BigDecimal getInterval () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Interval);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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

	/** Set Start Date.
		@param StartDate 
		First effective day (inclusive)
	  */
	public void setStartDate (Timestamp StartDate)
	{
		set_Value (COLUMNNAME_StartDate, StartDate);
	}

	/** Get Start Date.
		@return First effective day (inclusive)
	  */
	public Timestamp getStartDate () 
	{
		return (Timestamp)get_Value(COLUMNNAME_StartDate);
	}

	/** TimeUnit AD_Reference_ID=53376 */
	public static final int TIMEUNIT_AD_Reference_ID=53376;
	/** Day = D */
	public static final String TIMEUNIT_Day = "D";
	/** Week = W */
	public static final String TIMEUNIT_Week = "W";
	/** Month = M */
	public static final String TIMEUNIT_Month = "M";
	/** Quarter = Q */
	public static final String TIMEUNIT_Quarter = "Q";
	/** Year = Y */
	public static final String TIMEUNIT_Year = "Y";
	/** Hour = H */
	public static final String TIMEUNIT_Hour = "H";
	/** Minute = I */
	public static final String TIMEUNIT_Minute = "I";
	/** Set Time Unit.
		@param TimeUnit 
		The unit of time for grouping chart data.
	  */
	public void setTimeUnit (String TimeUnit)
	{

		set_Value (COLUMNNAME_TimeUnit, TimeUnit);
	}

	/** Get Time Unit.
		@return The unit of time for grouping chart data.
	  */
	public String getTimeUnit () 
	{
		return (String)get_Value(COLUMNNAME_TimeUnit);
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