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

/** Generated Model for AM_MPTaskResourse
 *  @author Adempiere (generated) 
 *  @version Release 3.9.3 - $Id$ */
public class X_AM_MPTaskResourse extends PO implements I_AM_MPTaskResourse, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200401L;

    /** Standard Constructor */
    public X_AM_MPTaskResourse (Properties ctx, int AM_MPTaskResourse_ID, String trxName)
    {
      super (ctx, AM_MPTaskResourse_ID, trxName);
      /** if (AM_MPTaskResourse_ID == 0)
        {
			setAM_MPTaskResourse_ID (0);
			setC_UOM_ID (0);
			setCost (Env.ZERO);
			setM_Product_ID (0);
			setPrice (Env.ZERO);
			setProductType (null);
			setQtyRequired (Env.ZERO);
// 1
        } */
    }

    /** Load Constructor */
    public X_AM_MPTaskResourse (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_AM_MPTaskResourse[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.eam.model.I_AM_MaintenancePattern getAM_MaintenancePattern() throws RuntimeException
    {
		return (org.eam.model.I_AM_MaintenancePattern)MTable.get(getCtx(), org.eam.model.I_AM_MaintenancePattern.Table_Name)
			.getPO(getAM_MaintenancePattern_ID(), get_TrxName());	}

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

	public org.eam.model.I_AM_MaintenancePattern_Task getAM_MaintenancePattern_Task() throws RuntimeException
    {
		return (org.eam.model.I_AM_MaintenancePattern_Task)MTable.get(getCtx(), org.eam.model.I_AM_MaintenancePattern_Task.Table_Name)
			.getPO(getAM_MaintenancePattern_Task_ID(), get_TrxName());	}

	/** Set Task.
		@param AM_MaintenancePattern_Task_ID Task	  */
	public void setAM_MaintenancePattern_Task_ID (int AM_MaintenancePattern_Task_ID)
	{
		if (AM_MaintenancePattern_Task_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AM_MaintenancePattern_Task_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AM_MaintenancePattern_Task_ID, Integer.valueOf(AM_MaintenancePattern_Task_ID));
	}

	/** Get Task.
		@return Task	  */
	public int getAM_MaintenancePattern_Task_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AM_MaintenancePattern_Task_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set AM_MPTaskResourse ID.
		@param AM_MPTaskResourse_ID AM_MPTaskResourse ID	  */
	public void setAM_MPTaskResourse_ID (int AM_MPTaskResourse_ID)
	{
		if (AM_MPTaskResourse_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AM_MPTaskResourse_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AM_MPTaskResourse_ID, Integer.valueOf(AM_MPTaskResourse_ID));
	}

	/** Get AM_MPTaskResourse ID.
		@return AM_MPTaskResourse ID	  */
	public int getAM_MPTaskResourse_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AM_MPTaskResourse_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.compiere.model.I_C_UOM getC_UOM() throws RuntimeException
    {
		return (org.compiere.model.I_C_UOM)MTable.get(getCtx(), org.compiere.model.I_C_UOM.Table_Name)
			.getPO(getC_UOM_ID(), get_TrxName());	}

	/** Set UOM.
		@param C_UOM_ID 
		Unit of Measure
	  */
	public void setC_UOM_ID (int C_UOM_ID)
	{
		if (C_UOM_ID < 1) 
			set_Value (COLUMNNAME_C_UOM_ID, null);
		else 
			set_Value (COLUMNNAME_C_UOM_ID, Integer.valueOf(C_UOM_ID));
	}

	/** Get UOM.
		@return Unit of Measure
	  */
	public int getC_UOM_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_UOM_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Cost.
		@param Cost 
		Cost information
	  */
	public void setCost (BigDecimal Cost)
	{
		set_Value (COLUMNNAME_Cost, Cost);
	}

	/** Get Cost.
		@return Cost information
	  */
	public BigDecimal getCost () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Cost);
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

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException
    {
		return (org.compiere.model.I_M_Product)MTable.get(getCtx(), org.compiere.model.I_M_Product.Table_Name)
			.getPO(getM_Product_ID(), get_TrxName());	}

	/** Set Product.
		@param M_Product_ID 
		Product, Service, Item
	  */
	public void setM_Product_ID (int M_Product_ID)
	{
		if (M_Product_ID < 1) 
			set_Value (COLUMNNAME_M_Product_ID, null);
		else 
			set_Value (COLUMNNAME_M_Product_ID, Integer.valueOf(M_Product_ID));
	}

	/** Get Product.
		@return Product, Service, Item
	  */
	public int getM_Product_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_Product_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Price.
		@param Price 
		Price
	  */
	public void setPrice (BigDecimal Price)
	{
		set_Value (COLUMNNAME_Price, Price);
	}

	/** Get Price.
		@return Price
	  */
	public BigDecimal getPrice () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Price);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** ProductType AD_Reference_ID=270 */
	public static final int PRODUCTTYPE_AD_Reference_ID=270;
	/** Item = I */
	public static final String PRODUCTTYPE_Item = "I";
	/** Service = S */
	public static final String PRODUCTTYPE_Service = "S";
	/** Resource = R */
	public static final String PRODUCTTYPE_Resource = "R";
	/** Expense type = E */
	public static final String PRODUCTTYPE_ExpenseType = "E";
	/** Online = O */
	public static final String PRODUCTTYPE_Online = "O";
	/** Set Product Type.
		@param ProductType 
		Type of product
	  */
	public void setProductType (String ProductType)
	{

		set_Value (COLUMNNAME_ProductType, ProductType);
	}

	/** Get Product Type.
		@return Type of product
	  */
	public String getProductType () 
	{
		return (String)get_Value(COLUMNNAME_ProductType);
	}

	/** Set Qty Required.
		@param QtyRequired Qty Required	  */
	public void setQtyRequired (BigDecimal QtyRequired)
	{
		set_Value (COLUMNNAME_QtyRequired, QtyRequired);
	}

	/** Get Qty Required.
		@return Qty Required	  */
	public BigDecimal getQtyRequired () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyRequired);
		if (bd == null)
			 return Env.ZERO;
		return bd;
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
}