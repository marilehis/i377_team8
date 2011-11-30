package ee.itcollege.i377.entities;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class SurrogaatKuupaev {
	
	public static Date getInstance() {
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(9999, 12 - 1, 31);
		return cal.getTime();		
	}

}
