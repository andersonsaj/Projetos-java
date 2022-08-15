package application3;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Program {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date d = Date.from(Instant.parse("2018-06-25T15:42:07Z"));
		
		System.out.println(sdf.format(d));
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		int minutes = cal.get(Calendar.MINUTE); 
		int month = 1 + cal.get(Calendar.MONTH);
		int dia = cal.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(sdf.format(d));
		System.out.println(minutes);
		System.out.println(month);
		System.out.println(dia);
		System.out.println();
		if (25 == dia || 06 == month ) {
			System.out.println(dia+"/"+month);
		}

	}

}
