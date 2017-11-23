package fiap.persistencia.atividade.utils;

import java.util.Calendar;
import java.sql.Date;

public class Utils {
	public static Calendar toCalendar(Date date){ 
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	
	public static Date toDate(Calendar data){
		return new Date(data.getTimeInMillis());
	}
}
