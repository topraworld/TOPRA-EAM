package org.eam.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;

public class MAMMaintenancePatternTask extends X_AM_MaintenancePattern_Task{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MAMMaintenancePatternTask(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MAMMaintenancePatternTask(Properties ctx, int AM_MaintenancePattern_Task_ID, String trxName) {
		super(ctx, AM_MaintenancePattern_Task_ID, trxName);
	}
	
	protected boolean beforeSave (boolean newRecord){
		//System.out.println(this.Table_Name);
		return true;
	}
	
	 public MAMMPTaskResourse [] getResourcesList(Properties ctx, String trxName){

		List<MAMMPTaskResourse> list = new Query(ctx, MAMMPTaskResourse.Table_Name, COLUMNNAME_AM_MaintenancePattern_Task_ID+"=?", trxName)
			.setParameters(this.get_ID())
			.setOnlyActiveRecords(true)
			.setOrderBy(MAMMPTaskResourse.COLUMNNAME_SeqNo)
			.list();
		return list.toArray(new MAMMPTaskResourse[list.size()]);
    }
}
