package com.masai.exception;

public class DriverNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DriverNotFoundException() {
		
	}
	public DriverNotFoundException(String msg) {
		super(msg);
	}
}
