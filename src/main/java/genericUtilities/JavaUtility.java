package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class consists of generic methods related to Java
 * @author Chaitra M
 *
 */
public class JavaUtility {
	
	/**
	 * This method will capture the current system date in format and return to caller
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
		String date = s.format(d);
		return date;
	}

}
