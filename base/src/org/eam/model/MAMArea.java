package org.eam.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MAMArea extends X_AM_Area{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MAMArea(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MAMArea(Properties ctx, int AM_Area_ID, String trxName) {
		super(ctx, AM_Area_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	protected boolean beforeSave (boolean newRecord){
		
		//System.out.println(this.Table_Name);
		
		return true;
	}
	
}
