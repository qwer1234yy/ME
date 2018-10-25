package myutils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTools {
	public static String getUniqeFilename() {
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MMmm");
		return format.format(now).toString();
	}
}
