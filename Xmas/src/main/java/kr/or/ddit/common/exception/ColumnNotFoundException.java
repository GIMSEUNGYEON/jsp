package kr.or.ddit.common.exception;

public class ColumnNotFoundException extends RuntimeException {
	
	private int status;
	
	public ColumnNotFoundException(String message) {
		this(500, message);
	}

	public ColumnNotFoundException(int status, String message) {
		super(message);
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}
}
