package org.eam.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MAMWorkDayCalander extends X_AM_WorkDayCalander{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MAMWorkDayCalander(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MAMWorkDayCalander(Properties ctx, int AM_WorkDayCalander_ID, String trxName) {
		super(ctx, AM_WorkDayCalander_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	protected boolean beforeSave (boolean newRecord){
		
		return true;
	}
}