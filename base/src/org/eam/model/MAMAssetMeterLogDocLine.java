package org.eam.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.Query;
import org.compiere.util.DB;

public class MAMAssetMeterLogDocLine extends X_AM_AssetMeterLogDocLine{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public MAMAssetMeterLogDocLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MAMAssetMeterLogDocLine(Properties ctx, int AM_AssetMeterLogDocLine_ID, String trxName) {
		super(ctx, AM_AssetMeterLogDocLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	
	protected boolean beforeSave (boolean newRecord){
		
		//set line no
		if (getLine() == 0){
			String sql = "SELECT COALESCE(MAX(line),0)+1 AS DefaultValue FROM AM_AssetMeterLogDocLine WHERE AM_AssetMeterLogDoc_ID=?";
			int ii = DB.getSQLValue (get_TrxName(), sql, getAM_AssetMeterLogDoc_ID());
			setLine(ii);
		}
		
		//validate for duplicates
		int count = new Query(getCtx(), Table_Name,
			" A_Asset_ID = ? AND AM_Meter_ID = ? "
			+"AND AM_AssetMeterLogDoc_ID=? AND AM_AssetMeterLogDocLine_ID <> ? "
			, null)
			.setParameters(getA_Asset_ID() , getAM_Meter_ID() ,getAM_AssetMeterLogDoc_ID() ,get_ID())
			.setOnlyActiveRecords(true)
			.list().size();
			
			if(count >=1)
				throw new AdempiereException("Difinitaion of duplicate meter - " + getAM_Meter().getName());
		
		return true;
	}
	
}
