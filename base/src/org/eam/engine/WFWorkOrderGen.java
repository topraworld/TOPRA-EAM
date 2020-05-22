package org.eam.engine;

import org.compiere.process.SvrProcess;
import org.compiere.util.Env;
import org.eam.model.MAMCalenderSchedule;
import org.eam.model.MAMMaintenance;
import org.eam.model.MAMServiceOrder;

//org.eam.engine.WFWorkOrderGen
public class WFWorkOrderGen extends SvrProcess{

	@Override
	protected void prepare() { }

	@Override
	protected String doIt() throws Exception {
		Thread t = new Thread(new WorkOrder(getRecord_ID()));
		t.start();
		return "Done!!";
	}
}

class WorkOrder implements Runnable{
	
	private int AM_CalenderSchedule_ID;
	
	protected WorkOrder(int AM_CalenderSchedule_ID){
		this.AM_CalenderSchedule_ID = AM_CalenderSchedule_ID;
	} 

	@Override
	public void run() {
		
		try {
			
			//This will create Work orders for calender schedule
			MAMCalenderSchedule cs = new MAMCalenderSchedule(Env.getCtx(), AM_CalenderSchedule_ID, null);
			
			if(cs.getAM_ServiceOrder_ID() != 0)//already generated
				return;
			
			MAMMaintenance pm = (MAMMaintenance) cs.getAM_Maintenance();
			
			//Generating work order
			MAMServiceOrder wo = new MAMServiceOrder(Env.getCtx(), 0, null);
			wo.setAM_Maintenance_ID(pm.get_ID());
			wo.setDateDoc(cs.getDateScheduled());
			wo.setM_PriceList_ID(pm.getM_PriceList_ID());
			wo.setA_Asset_ID(cs.getA_Asset_ID());
			wo.setDateStartPlan(wo.getDateDoc());
			wo.setDescription("***System process - generated by the PM action schedule***");
			wo.setAM_CalenderSchedule_ID(AM_CalenderSchedule_ID);
			wo.save();
			wo.prepareIt(); //just to copy pm schedule >> wo schedule 
			
			cs.setAM_ServiceOrder_ID(wo.get_ID());
			cs.save();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
} 
