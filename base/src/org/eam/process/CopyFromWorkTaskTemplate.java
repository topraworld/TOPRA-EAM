package org.eam.process;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;
import org.eam.model.MAMMPTaskResourse;
import org.eam.model.MAMMaintenancePattern;
import org.eam.model.MAMMaintenancePatternTask;

//org.eam.process.CopyFromWorkTaskTemplate
public class CopyFromWorkTaskTemplate extends SvrProcess {

	private int Record_ID , AM_MaintenancePattern_ID;
	private MAMMaintenancePattern copyTo , parent;
	
	@Override
	protected void prepare() {
		Record_ID = getRecord_ID();
		AM_MaintenancePattern_ID = getParameterAsInt("AM_MaintenancePattern_ID");
		
		copyTo = new MAMMaintenancePattern(getCtx(), Record_ID, null);
		//validate document status
		if(!(copyTo.getDocStatus().equals("DR") || copyTo.getDocStatus().equals("IP")))
			throw new AdempiereException("Invalid document status!");
		parent = new MAMMaintenancePattern(getCtx(), AM_MaintenancePattern_ID, null);
	}

	@Override
	protected String doIt() throws Exception {

		//Delete existing tasks and resources
		String sql = ""
				+ "DELETE FROM AM_MaintenancePattern_Task WHERE AM_MaintenancePattern_ID = ?; "
				+ "DELETE FROM AM_MPTaskResourse WHERE AM_MaintenancePattern_ID = ?; ";
		DB.executeUpdate(sql, new Object[]{Record_ID , Record_ID},false, null);
		
		MAMMaintenancePatternTask [] tasks  = parent.getTaskList(getCtx(), get_TrxName());
		
		MAMMaintenancePatternTask taskTo = null;
		MAMMPTaskResourse [] recources = null;
		MAMMPTaskResourse copyToRes = null;
		
		for(MAMMaintenancePatternTask task : tasks){
			
			taskTo = new MAMMaintenancePatternTask(getCtx(), 0, null);
			MAMMaintenancePatternTask.copyValues(task, taskTo);
			taskTo.setAM_MaintenancePattern_ID(Record_ID);
			taskTo.save();
			
			recources  = task.getResourcesList(getCtx(), null);
			
			for(MAMMPTaskResourse from : recources){
				
				copyToRes = new MAMMPTaskResourse(getCtx(), 0, null);
				
				MAMMPTaskResourse.copyValues(from, copyToRes);
				copyToRes.setAM_MaintenancePattern_Task_ID(taskTo.get_ID());
				copyToRes.setAM_MaintenancePattern_ID(Record_ID);
				copyToRes.save();
			}
		}
		
		copyTo.setParent_ID(parent.get_ID());
		copyTo.save();
		
		return "Copied : Task - "+ tasks.length;
	}
}
