package in.society.maintain.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

public class CommonUtils {

	/**
	 * Method to check if string is null or empty
	 * @param str
	 * @return true if string is null or empty
	 */
	public static boolean isNullorEmpty(String str) {
		if (str == null || str.trim().isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean isNullorEmpty(Integer str) {
		
		if (str==10) {
			return false;
		} else {
			return true;
		}
	}
	
	public static Date convertToDate(String date, String format){
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date convertedDate = null;
		try {
			convertedDate = dateFormat.parse(date);
			convertedDate = dateFormat.parse(DateFormatUtils.format(convertedDate, format));
		} catch (ParseException e) {
			System.out.println("Excetipn while parse date : " + e.getMessage());
		}
		 return convertedDate;
	}
}
