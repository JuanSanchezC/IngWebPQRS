package co.edu.udea.iw.logs;

import org.apache.log4j.Logger;

public class CustomLogger {
	
	public static Logger getLogger() {
		return Logger.getLogger("customLogger");
	}

}
