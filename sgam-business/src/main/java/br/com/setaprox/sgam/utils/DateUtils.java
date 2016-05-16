package br.com.setaprox.sgam.utils;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static String convertDateToString( Date date, String formato ) {
		
		if( date == null ) {
			
			return "";
			
		}
		
		Format formatter = new SimpleDateFormat( formato );
		
		return formatter.format(date);
	}
	
	public static Date convertStringToDate( String strDate, String formato ) throws ParseException {
		
		DateFormat formatter = new SimpleDateFormat( formato );
		
		return formatter.parse(strDate);
		
	}
	
	public static boolean equal( Calendar c1, Calendar c2 ) {
	    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	    return (sdf.format(c1.getTime()).equals(sdf.format(c2.getTime())));
	}
	
}
