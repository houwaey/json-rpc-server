package com.jsonrpc.exceptions;

public class UserExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserExistsException() {
		super();
	}

	public UserExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserExistsException(String message) {
		super(message);
	}

	public UserExistsException(Throwable cause) {
		super(cause);
	}
	
}
