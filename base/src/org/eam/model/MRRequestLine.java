package org.eam.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.util.DB;

public class MRRequestLine extends X_R_RequestLine{

	public MRRequestLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public MRRequestLine(Properties ctx, int R_RequestLine_ID, String trxName) {
		super(ctx, R_RequestLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	protected boolean beforeSave (boolean newRecord) {
		
		//set Line No
		if (getLine() == 0){
			String sql = "SELECT COALESCE(MAX(Line),0)+1 AS DefaultValue FROM R_RequestLine WHERE R_Request_ID=?";
			int ii = DB.getSQLValue (get_TrxName(), sql, getR_Request_ID());
			setLine (ii);
		}
		return true;
	}
	
}
