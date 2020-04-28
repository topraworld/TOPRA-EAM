package org.eam.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.model.MPriceList;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MProduct;
import org.compiere.model.MProductPrice;
import org.compiere.util.DB;

public class MAMServiceOrderResource extends X_AM_ServiceOrderResource{

	public MAMServiceOrderResource(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MAMServiceOrderResource(Properties ctx, int AM_ServiceOrderResource_ID, String trxName) {
		super(ctx, AM_ServiceOrderResource_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	protected boolean beforeSave (boolean newRecord){

		//set Line No
		if (getLine() == 0){
			String sql = "SELECT NVL(MAX(Line),0)+1 AS DefaultValue FROM AM_ServiceOrderResource WHERE AM_ServiceOrderTask_ID=?";
			int ii = DB.getSQLValue (get_TrxName(), sql, getAM_ServiceOrderTask_ID());
			setLine (ii);
		}
		
		//setting up the price based on the price list
		MAMServiceOrder wo = (MAMServiceOrder) getAM_ServiceOrder();
		MProduct product = (MProduct) getM_Product();
		
		MPriceList pl = (MPriceList) wo.getM_PriceList();
		MPriceListVersion plv = pl.getPriceListVersion(new Timestamp(System.currentTimeMillis()));
		
		//MAKE PRICE ZERO
		setPrice(new BigDecimal(0));
		setCostAmtPlan(getPrice());
		setCostAmt(getPrice());
		
		if(plv != null){ //is no prices are available
			MProductPrice[] prices  = plv.getProductPrice(" AND M_Product_ID="+product.get_ID());
			if(prices == null || prices.length == 0){
				//no prices
			}else{
				MProductPrice price  = prices[prices.length - 1];
				setPrice(price.getPriceList());
				setCostAmtPlan(price.getPriceList().multiply(this.getQtyPlan()));
			}
		}
		//SET ACTUAL COST
		setCostAmt(getPrice().multiply(getQtyDelivered()));
		//SET UOM
		setC_UOM_ID(product.getC_UOM_ID());		
		
		return true;
	}

}
