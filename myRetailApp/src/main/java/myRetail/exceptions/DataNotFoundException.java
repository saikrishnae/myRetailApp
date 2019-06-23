package myRetail.exceptions;

public class DataNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	Integer statusCode;
	String errorMessage;

	public DataNotFoundException(Integer statusCode, String errorMessage) {
		super();
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
