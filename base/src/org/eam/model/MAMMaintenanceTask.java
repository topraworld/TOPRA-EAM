package org.eam.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.util.DB;

public class MAMMaintenanceTask extends X_AM_Maintenance_Task{
	
	private static final long serialVersionUID = 1L;

	public MAMMaintenanceTask(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MAMMaintenanceTask(Properties ctx, int AM_Maintenance_Task_ID, String trxName) {
		super(ctx, AM_Maintenance_Task_ID, trxName);
	}
	
	protected boolean beforeSave (boolean newRecord){
		
		//Get Line No
		if (getLine() == 0){
			String sql = "SELECT COALESCE(MAX(Line),0)+10 AS DefaultValue FROM AM_Maintenance_Task WHERE AM_Maintenance_ID=?";
			int ii = DB.getSQLValue (get_TrxName(), sql, getAM_Maintenance_ID());
			setLine (ii);
		}
		return true;
	}
	
	 protected boolean beforeDelete (){
			
		 String sql = "DELETE FROM AM_Maintenance_Resource WHERE AM_Maintenance_Task_ID=?";
		 DB.executeUpdate(sql, this.get_ID(), null);
	
		return true;
	}
}
