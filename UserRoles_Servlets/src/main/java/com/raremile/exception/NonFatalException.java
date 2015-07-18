package com.raremile.exception;

/**
 * Non fatal exception
 * 
 * @author RohanV
 *
 */

public class NonFatalException extends Exception {

	/**
	 * default serial version id
	 */
	private static final long serialVersionUID = 1L;

	public NonFatalException() {
		super();
	}

	public NonFatalException(String message) {
		super(message);
	}

	public NonFatalException(String message, Throwable thrw) {
		super(message, thrw);
	}
}
