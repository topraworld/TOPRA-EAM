/******************************************************************************
 * Product: Adempiere ERP & CRM Smart Business Solution                       *
 * This program is free software; you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY; without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program; if not, see http://www.gnu.org/licenses or write to the * 
 * Free Software Foundation, Inc.,                                            *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * Copyright (C) 2003-2016                                                    *
 * All Rights Reserved.                                                       *
 *****************************************************************************/
package org.eam.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MInvoice;
import org.compiere.model.Query;
import org.compiere.util.CCache;

/**
 * Meter class
 * @contributor Mario Calderon, Systemhaus Westfalia, http://www.westfalia-it.com
 * @contributor Adaxa http://www.adaxa.com
 * @contributor Deepak Pansheriya, Loglite Technologies, http://logilite.com
 * @contributor Victor Perez, victor.perez@e-evolution.com, eEvolution http://www.e-evolution.com
 * @contributor Yamel Senih, ysenih@erpcya.com, ERPCyA http://www.erpcya.com
 */
public class MAMAssetMeter extends X_AM_AssetMeter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 920285726461219946L;

	public MAMAssetMeter(Properties ctx, int AM_Meter_ID, String trxName) {
		super(ctx, AM_Meter_ID, trxName);
	}

	public MAMAssetMeter(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
	
	/**	Cache						*/
	private static CCache<Integer, MAMAssetMeter> cache = new CCache<Integer, MAMAssetMeter>(Table_Name, 40, 5);	//	5 minutes
	
	//avoid adding duplicates
	protected boolean beforeSave (boolean newRecord){
		//avoid adding duplicates
		int count = new Query(getCtx(), Table_Name, "A_Asset_ID = ? AND AM_Meter_ID = ? AND AM_AssetMeter_ID <> ? ", null)
			.setParameters(getA_Asset_ID() , getAM_Meter_ID() , get_ID())
			.setOnlyActiveRecords(true)
		.list().size();
		
		if(count >=1)
			throw new AdempiereException("Difinitaion of duplicate meter - " + getAM_Meter().getName());
		
		return true;
	}
	
	protected MAMAssetMeterLog [] getLines(){
	 
		List<MAMAssetMeterLog> list = new Query(getCtx(), "AM_AssetMeter_Log","AM_AssetMeter_ID = ? ", null)
			.setParameters(get_ID())
			.setOnlyActiveRecords(true)
			.list();
		
		return list.toArray(new MAMAssetMeterLog[list.size()]);
	}
	
	
	protected int getLineCount(boolean newRecord){
		
		int count = new Query(getCtx(), "AM_AssetMeter_Log", "AM_AssetMeter_ID = ? ", get_TrxName())
			.setParameters(get_ID())
			.setOnlyActiveRecords(true)
			.list().size();
		count = newRecord ? ++count: count;
		return count;
	}
	
	
	/**
	 * Get from cache
	 * @param ctx
	 * @param meterId
	 * @return
	 */
	public static MAMAssetMeter get (Properties ctx, int meterId) {
		if (meterId <= 0) {
			return null;
		}
		MAMAssetMeter retValue = (MAMAssetMeter) cache.get (meterId);
		if (retValue != null) {
			return retValue;
		}
		retValue = new MAMAssetMeter(ctx, meterId, null);
		if (retValue.get_ID () != 0) {
			cache.put (meterId, retValue);
		}
		return retValue;
	}	//	get
}
