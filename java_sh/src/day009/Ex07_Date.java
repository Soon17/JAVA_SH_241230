package day009;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex07_Date {

	public static void main(String[] args) throws ParseException {
		Date d= new Date();
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = format.format(d);
		System.out.println(str);
		
		str = "2024-01-01 14:30:00";
		d = format.parse(str);
		System.out.println(d);
	}

}
