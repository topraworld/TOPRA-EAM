package org.eam.engine;

import org.compiere.process.SvrProcess;

//PM Action - Calender base date updator
//org.eam.engine.CalenderDateUpdator
public class CalDuePercentage extends SvrProcess{

	@Override
	protected void prepare() { }

	@Override
	protected String doIt() throws Exception {
		
		String sql = "SELECT "
			+ "M.AM_Maintenance_ID , "
			+ "MIN(sc.SeqNo FROM AM_CalenderSchedule sc "
			+ "INNER JOIN AM_Maintenance M "
			+ "ON sc.AM_Maintenance_ID = M .AM_Maintenance_ID "
			+ "WHERE sc. TYPE = 'C' AND "
			+ "sc.status = 'OP' AND "
			+ "sc.isactive = 'Y' AND "
			+ "M .docstatus = 'CO' GROUP BY 1 ";
		
		//DB.
		
		return "Done!";
	}
}
