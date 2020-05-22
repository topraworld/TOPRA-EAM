package org.eam.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;
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
		
		//set Line No
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
	 
	protected static int getTaskCount(Properties ctx,int AM_Maintenance_ID , String trxName){
		List<MAMMaintenanceTask> list = new Query(ctx, Table_Name, "AM_Maintenance_ID=?", trxName)
			.setParameters(AM_Maintenance_ID)
			.setOnlyActiveRecords(true)
		.list();
		return list.size();
    }
	 
	protected MAMMaintenanceResource [] getResources(){
		
		List<MAMMaintenanceResource> list = new Query(getCtx(), MAMMaintenanceResource.Table_Name, "AM_Maintenance_Task_ID=?", null)
			.setParameters(get_ID())
			.setOnlyActiveRecords(true)
			.list();
		return list.toArray(new MAMMaintenanceResource[list.size()]);
	}
}
