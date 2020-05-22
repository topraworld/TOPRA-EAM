package org.eam.process;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.process.SvrProcess;
import org.eam.model.MAMMPTaskResourse;
import org.eam.model.MAMMaintenance;
import org.eam.model.MAMMaintenancePattern;
import org.eam.model.MAMMaintenancePatternTask;
import org.eam.model.MAMMaintenanceResource;
import org.eam.model.MAMMaintenanceTask;

//org.eam.process.CopyWorkTaskTemToPMAction
public class CopyWorkTaskTemToPMAction  extends SvrProcess {

	private int Record_ID , AM_MaintenancePatern_ID;
	private MAMMaintenancePattern wtt;
	private MAMMaintenance pm;
	
	@Override
	protected void prepare() {
		
		Record_ID = getRecord_ID();
		AM_MaintenancePatern_ID = getParameterAsInt("AM_MaintenancePatern_ID");
		
		wtt = new MAMMaintenancePattern(getCtx(), AM_MaintenancePatern_ID, null);
		pm = new MAMMaintenance(getCtx(), Record_ID, null);
		
		//validate document status
		if(!(pm.getDocStatus().equals("DR") || pm.getDocStatus().equals("IP")))
			throw new AdempiereException("Invalid document status!");
	}

	@Override
	protected String doIt() throws Exception {
		
		MAMMaintenancePatternTask [] wtt_Tasks  = wtt.getTaskList(getCtx(), get_TrxName());
		MAMMaintenanceTask pm_task = null;
		MAMMPTaskResourse [] wtt_ress = null;
		MAMMaintenanceResource pm_res = null;
		
		for(MAMMaintenancePatternTask wtt_task : wtt_Tasks){
			
			//create tasks for PM action
			pm_task = new MAMMaintenanceTask(getCtx(), 0, null);
			pm_task.setAM_Maintenance_ID(Record_ID);
			pm_task.setName(wtt_task.getName());
			pm_task.setC_UOM_ID(wtt_task.getC_UOM_ID());
			pm_task.setDuration(wtt_task.getDuration());
			pm_task.setDescription(wtt_task.getDescription());
			pm_task.save();
			
			//create resource lines
			wtt_ress = wtt_task.getResourcesList(getCtx(), null);
			for(MAMMPTaskResourse res : wtt_ress){
				pm_res = new MAMMaintenanceResource(getCtx(), 0, null);
				pm_res.setAM_Maintenance_ID(Record_ID);
				pm_res.setAM_Maintenance_Task_ID(pm_task.get_ID());
				pm_res.setProductType(res.getProductType());
				pm_res.setM_Product_ID(res.getM_Product_ID());
				pm_res.setC_UOM_ID(res.getC_UOM_ID());
				pm_res.setQtyRequired(res.getQtyRequired());
				pm_res.setDescription(res.getDescription());
				pm_res.save();
			}
		}
		pm.setAM_MaintenancePatern_ID(AM_MaintenancePatern_ID);
		pm.save();
		return "Copied : Task - "+ wtt_Tasks.length;
	}
}
