package org.eam.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.util.DB;

@SuppressWarnings("serial")
public class MAMCalenderSchedule extends X_AM_CalenderSchedule{

	public MAMCalenderSchedule(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MAMCalenderSchedule(Properties ctx, int AM_CalenderSchedule_ID, String trxName) {
		super(ctx, AM_CalenderSchedule_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	protected boolean beforeSave (boolean newRecord){
		
		if (getSeqNo() == 0){
			String sql = "SELECT COALESCE(MAX(SeqNo),0)+1 AS DefaultValue FROM AM_CalenderSchedule WHERE AM_Maintenance_ID=? AND A_Asset_ID = ?";
			
			int ii = DB.getSQLValue (null, sql, getAM_Maintenance_ID() , getA_Asset_ID());
			setSeqNo (ii);
		}
		return true;
	}

}
