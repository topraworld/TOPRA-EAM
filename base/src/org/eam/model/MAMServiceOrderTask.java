package org.eam.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.util.DB;

public class MAMServiceOrderTask extends X_AM_ServiceOrderTask{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MAMServiceOrderTask(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MAMServiceOrderTask(Properties ctx, int AM_ServiceOrderTask_ID, String trxName) {
		super(ctx, AM_ServiceOrderTask_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	protected boolean beforeSave (boolean newRecord){

		//set Line No
		if (getLine() == 0){
			String sql = "SELECT COALESCE(MAX(Line),0)+1 AS DefaultValue FROM AM_ServiceOrderTask WHERE AM_ServiceOrder_ID=?";
			int ii = DB.getSQLValue (get_TrxName(), sql, getAM_ServiceOrder_ID());
			setLine (ii);
		}
		return true;
	}
}
