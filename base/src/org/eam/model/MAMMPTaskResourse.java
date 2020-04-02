package org.eam.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MPriceList;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MProduct;
import org.compiere.model.MProductPrice;

public class MAMMPTaskResourse extends X_AM_MPTaskResourse{

	public MAMMPTaskResourse(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MAMMPTaskResourse(Properties ctx, int AM_MPTaskResourse_ID, String trxName) {
		super(ctx, AM_MPTaskResourse_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	protected boolean beforeSave (boolean newRecord){
		
		//setting up the price based on the price list
		MAMMaintenancePattern mp = (MAMMaintenancePattern) getAM_MaintenancePattern();
		MProduct product = (MProduct) getM_Product();
		
		MPriceList pl = (MPriceList) mp.getM_PriceList();
		MPriceListVersion plv = pl.getPriceListVersion(new Timestamp(System.currentTimeMillis()));
		
		if(plv != null){ //is no prices are available
			MProductPrice[] prices  = plv.getProductPrice(" AND M_Product_ID="+product.get_ID());
			if(prices == null || prices.length == 0){
				//no prices
			}else{
				MProductPrice price  = prices[prices.length - 1];
				this.setPrice(price.getPriceList());
				this.setCost(price.getPriceList().multiply(this.getQtyRequired()));
			}
		}
		return true;
	}
	
	protected boolean afterSave (boolean newRecord, boolean success) {
		
		//set total cost of the task
		
		return success;
	}	//	afterSave

}
