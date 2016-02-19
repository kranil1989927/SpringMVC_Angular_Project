package in.society.maintain.common;

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
		
		if (str.SIZE==10) {
			return false;
		} else {
			return true;
		}
	}
}
