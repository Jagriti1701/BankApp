package com.ion.bankapp.exception;

public class BankException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final int errorCode;

	public BankException(int errorCode) {
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

}
