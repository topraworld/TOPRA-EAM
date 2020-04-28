package test;

import java.sql.Timestamp;
import java.util.Calendar;

public class TestDateGToInterger {
	
	public static void main(String[] args) {
		
		Timestamp pDate = new Timestamp(System.currentTimeMillis());
		
		Calendar lCal = Calendar.getInstance();
		lCal.setTime(pDate);
		
		
		//lCal.getDaysNumber();
		
	}

}
