package com.miroshnichenco.webtester.l3.services.exception;

public class InvalidUserInputException  extends Exception {
	public InvalidUserInputException(String message) {
		super(message);
	}

	public InvalidUserInputException(Throwable cause) {
		super(cause);
	}

	public InvalidUserInputException(String message, Throwable cause) {
		super(message, cause);
	}
}
