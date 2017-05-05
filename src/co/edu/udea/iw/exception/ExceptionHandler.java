package co.edu.udea.iw.exception;

import org.apache.log4j.Logger;

import co.edu.udea.iw.logs.CustomLogger;

/**
 * Manage the exception that occur in the project execution
 * @author juan.sanchezc@udea.edu.co
 * @author oran.jimenez@udea.edu.co
 */
public class ExceptionHandler extends Exception {
	private static final long serialVersionUID = 1L;
	private Logger logger = CustomLogger.getLogger();
	
	public ExceptionHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExceptionHandler(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		logger.error(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ExceptionHandler(String message, Throwable cause) {
		super(message, cause);
		logger.error(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ExceptionHandler(String message) {
		super(message);
		logger.error(message);
		// TODO Auto-generated constructor stub
	}

	public ExceptionHandler(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public void printLog() {
		logger.error(getMessage(), this);
	}

}
