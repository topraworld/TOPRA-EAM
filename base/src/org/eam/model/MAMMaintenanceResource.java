package org.eam.model;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Properties;

import org.compiere.model.MPriceList;
import org.compiere.model.MPriceListVersion;
import org.compiere.model.MProduct;
import org.compiere.model.MProductPrice;
import org.compiere.util.DB;

public class MAMMaintenanceResource extends X_AM_Maintenance_Resource{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MAMMaintenanceResource(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MAMMaintenanceResource(Properties ctx, int AM_Maintenance_Resource_ID, String trxName) {
		super(ctx, AM_Maintenance_Resource_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	protected boolean beforeSave (boolean newRecord){
		
		//setting up the price based on the price list
		MAMMaintenance mm = (MAMMaintenance) getAM_Maintenance();
		MProduct product = (MProduct) getM_Product();
		
		MPriceList pl = (MPriceList) mm.getM_PriceList();
		MPriceListVersion plv = pl.getPriceListVersion(new Timestamp(System.currentTimeMillis()));
		
		if(plv != null){ //is no prices are available
			MProductPrice[] prices  = plv.getProductPrice(" AND M_Product_ID="+product.get_ID());
			if(prices == null || prices.length == 0){
				//no prices
			}else{
				MProductPrice price  = prices[prices.length - 1];
				this.setPrice(price.getPriceList());
				this.setCostAmt(price.getPriceList().multiply(this.getQtyRequired()));
			}
		}
		
		if (getLine() == 0)
		{
			String sql = "SELECT NVL(MAX(Line),0)+10 AS DefaultValue FROM AM_Maintenance_Resource WHERE AM_Maintenance_Task_ID=?";
			int ii = DB.getSQLValue (get_TrxName(), sql, getAM_Maintenance_Task_ID());
			setLine (ii);
		}
		
		return true;
	}
	
	

}
