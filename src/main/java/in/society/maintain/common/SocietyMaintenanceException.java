package in.society.maintain.common;

public class SocietyMaintenanceException extends Exception {

	private static final long serialVersionUID = 1628812411933981424L;

	public SocietyMaintenanceException() {
		super();
	}

	public SocietyMaintenanceException(String message) {
		super(message);
	}

	public SocietyMaintenanceException(Throwable cause) {
		super(cause);
	}

	public SocietyMaintenanceException(String message, Throwable cause) {
		super(message, cause);
	}

}
