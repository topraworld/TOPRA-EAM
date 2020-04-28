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

/** Generated Model for AM_ServiceOrderResource
 *  @author Adempiere (generated) 
 *  @version Release 3.9.3 - $Id$ */
public class X_AM_ServiceOrderResource extends PO implements I_AM_ServiceOrderResource, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20200422L;

    /** Standard Constructor */
    public X_AM_ServiceOrderResource (Properties ctx, int AM_ServiceOrderResource_ID, String trxName)
    {
      super (ctx, AM_ServiceOrderResource_ID, trxName);
      /** if (AM_ServiceOrderResource_ID == 0)
        {
			setAM_ServiceOrderResource_ID (0);
			setC_UOM_ID (0);
			setCostAmtPlan (Env.ZERO);
			setM_Product_ID (0);
			setProductType (null);
			setQtyPlan (Env.ZERO);
        } */
    }

    /** Load Constructor */
    public X_AM_ServiceOrderResource (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_AM_ServiceOrderResource[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public org.eam.model.I_AM_ServiceOrder getAM_ServiceOrder() throws RuntimeException
    {
		return (org.eam.model.I_AM_ServiceOrder)MTable.get(getCtx(), org.eam.model.I_AM_ServiceOrder.Table_Name)
			.getPO(getAM_ServiceOrder_ID(), get_TrxName());	}

	/** Set AM ServiceOrder.
		@param AM_ServiceOrder_ID AM ServiceOrder	  */
	public void setAM_ServiceOrder_ID (int AM_ServiceOrder_ID)
	{
		if (AM_ServiceOrder_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AM_ServiceOrder_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AM_ServiceOrder_ID, Integer.valueOf(AM_ServiceOrder_ID));
	}

	/** Get AM ServiceOrder.
		@return AM ServiceOrder	  */
	public int getAM_ServiceOrder_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AM_ServiceOrder_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set AM_ServiceOrderResource ID.
		@param AM_ServiceOrderResource_ID AM_ServiceOrderResource ID	  */
	public void setAM_ServiceOrderResource_ID (int AM_ServiceOrderResource_ID)
	{
		if (AM_ServiceOrderResource_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AM_ServiceOrderResource_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AM_ServiceOrderResource_ID, Integer.valueOf(AM_ServiceOrderResource_ID));
	}

	/** Get AM_ServiceOrderResource ID.
		@return AM_ServiceOrderResource ID	  */
	public int getAM_ServiceOrderResource_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AM_ServiceOrderResource_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public org.eam.model.I_AM_ServiceOrderTask getAM_ServiceOrderTask() throws RuntimeException
    {
		return (org.eam.model.I_AM_ServiceOrderTask)MTable.get(getCtx(), org.eam.model.I_AM_ServiceOrderTask.Table_Name)
			.getPO(getAM_ServiceOrderTask_ID(), get_TrxName());	}

	/** Set AM_ServiceOrderTask ID.
		@param AM_ServiceOrderTask_ID AM_ServiceOrderTask ID	  */
	public void setAM_ServiceOrderTask_ID (int AM_ServiceOrderTask_ID)
	{
		if (AM_ServiceOrderTask_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_AM_ServiceOrderTask_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_AM_ServiceOrderTask_ID, Integer.valueOf(AM_ServiceOrderTask_ID));
	}

	/** Get AM_ServiceOrderTask ID.
		@return AM_ServiceOrderTask ID	  */
	public int getAM_ServiceOrderTask_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AM_ServiceOrderTask_ID);
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

	/** Set Cost Amt Plan.
		@param CostAmtPlan Cost Amt Plan	  */
	public void setCostAmtPlan (BigDecimal CostAmtPlan)
	{
		set_Value (COLUMNNAME_CostAmtPlan, CostAmtPlan);
	}

	/** Get Cost Amt Plan.
		@return Cost Amt Plan	  */
	public BigDecimal getCostAmtPlan () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_CostAmtPlan);
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

	public org.compiere.model.I_M_BOM getM_BOM() throws RuntimeException
    {
		return (org.compiere.model.I_M_BOM)MTable.get(getCtx(), org.compiere.model.I_M_BOM.Table_Name)
			.getPO(getM_BOM_ID(), get_TrxName());	}

	/** Set BOM.
		@param M_BOM_ID 
		Bill of Material
	  */
	public void setM_BOM_ID (int M_BOM_ID)
	{
		if (M_BOM_ID < 1) 
			set_Value (COLUMNNAME_M_BOM_ID, null);
		else 
			set_Value (COLUMNNAME_M_BOM_ID, Integer.valueOf(M_BOM_ID));
	}

	/** Get BOM.
		@return Bill of Material
	  */
	public int getM_BOM_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_M_BOM_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
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

	/** Set Delivered Quantity.
		@param QtyDelivered 
		Delivered Quantity
	  */
	public void setQtyDelivered (BigDecimal QtyDelivered)
	{
		set_Value (COLUMNNAME_QtyDelivered, QtyDelivered);
	}

	/** Get Delivered Quantity.
		@return Delivered Quantity
	  */
	public BigDecimal getQtyDelivered () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyDelivered);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Quantity Plan.
		@param QtyPlan 
		Planned Quantity
	  */
	public void setQtyPlan (BigDecimal QtyPlan)
	{
		set_Value (COLUMNNAME_QtyPlan, QtyPlan);
	}

	/** Get Quantity Plan.
		@return Planned Quantity
	  */
	public BigDecimal getQtyPlan () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyPlan);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Reserved Quantity.
		@param QtyReserved 
		Reserved Quantity
	  */
	public void setQtyReserved (BigDecimal QtyReserved)
	{
		set_Value (COLUMNNAME_QtyReserved, QtyReserved);
	}

	/** Get Reserved Quantity.
		@return Reserved Quantity
	  */
	public BigDecimal getQtyReserved () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_QtyReserved);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Resource Qty.
		@param ResourceQty Resource Qty	  */
	public void setResourceQty (BigDecimal ResourceQty)
	{
		set_Value (COLUMNNAME_ResourceQty, ResourceQty);
	}

	/** Get Resource Qty.
		@return Resource Qty	  */
	public BigDecimal getResourceQty () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ResourceQty);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Resource Qty Extra.
		@param ResourceQtyExtra Resource Qty Extra	  */
	public void setResourceQtyExtra (BigDecimal ResourceQtyExtra)
	{
		set_Value (COLUMNNAME_ResourceQtyExtra, ResourceQtyExtra);
	}

	/** Get Resource Qty Extra.
		@return Resource Qty Extra	  */
	public BigDecimal getResourceQtyExtra () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_ResourceQtyExtra);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	public org.compiere.model.I_S_Resource getS_Resource() throws RuntimeException
    {
		return (org.compiere.model.I_S_Resource)MTable.get(getCtx(), org.compiere.model.I_S_Resource.Table_Name)
			.getPO(getS_Resource_ID(), get_TrxName());	}

	/** Set Resource.
		@param S_Resource_ID 
		Resource
	  */
	public void setS_Resource_ID (int S_Resource_ID)
	{
		if (S_Resource_ID < 1) 
			set_Value (COLUMNNAME_S_Resource_ID, null);
		else 
			set_Value (COLUMNNAME_S_Resource_ID, Integer.valueOf(S_Resource_ID));
	}

	/** Get Resource.
		@return Resource
	  */
	public int getS_Resource_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_S_Resource_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Resource Assignment.
		@param S_ResourceAssignment_ID 
		Resource Assignment
	  */
	public void setS_ResourceAssignment_ID (int S_ResourceAssignment_ID)
	{
		if (S_ResourceAssignment_ID < 1) 
			set_Value (COLUMNNAME_S_ResourceAssignment_ID, null);
		else 
			set_Value (COLUMNNAME_S_ResourceAssignment_ID, Integer.valueOf(S_ResourceAssignment_ID));
	}

	/** Get Resource Assignment.
		@return Resource Assignment
	  */
	public int getS_ResourceAssignment_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_S_ResourceAssignment_ID);
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