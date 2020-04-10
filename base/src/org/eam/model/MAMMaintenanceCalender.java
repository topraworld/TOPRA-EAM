package org.eam.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MAMMaintenanceCalender extends X_AM_MaintenanceCalender{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MAMMaintenanceCalender(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MAMMaintenanceCalender(Properties ctx, int AM_MaintenanceCalender_ID, String trxName) {
		super(ctx, AM_MaintenanceCalender_ID, trxName);
	}
	
	protected boolean beforeSave (boolean newRecord){
		
		//validate PM action has more than calender schedule
		
		return true;
	}
}
