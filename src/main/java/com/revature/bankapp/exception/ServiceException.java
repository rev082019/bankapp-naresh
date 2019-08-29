package com.revature.bankapp.exception;

//user defined exception
public class ServiceException  extends Exception{

	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(String message, Throwable t) {
		super(message,t);
	}
}
