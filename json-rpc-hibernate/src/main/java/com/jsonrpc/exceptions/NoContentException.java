package com.jsonrpc.exceptions;

public class NoContentException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoContentException() {
		super();
	}

	public NoContentException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoContentException(String message) {
		super(message);
	}

	public NoContentException(Throwable cause) {
		super(cause);
	}

}
