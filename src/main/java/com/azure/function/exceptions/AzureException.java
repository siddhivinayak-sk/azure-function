package com.azure.function.exceptions;

/**
 * Custom Azure Exception to capture exceptions from Azure
 * @author Sandeep Kumar
 * 
 *
 */
public class AzureException extends Exception {

	private static final long serialVersionUID = 1L;

	public AzureException() {
		super();
	}

	public AzureException(String message) {
		super(message);
	}

	public AzureException(Throwable cause) {
		super(cause);
	}
}