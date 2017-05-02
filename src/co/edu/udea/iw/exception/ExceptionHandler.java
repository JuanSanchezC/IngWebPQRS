package co.edu.udea.iw.exception;

/**
 * Manage the exception that occur in the project execution
 * @author juan.sanchezc@udea.edu.co
 */
public class ExceptionHandler extends Exception {
	private static final long serialVersionUID = 1L;

	public ExceptionHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExceptionHandler(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ExceptionHandler(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ExceptionHandler(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ExceptionHandler(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
