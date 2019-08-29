package com.revature.bankapp.exception;

//user defined exception
public class DBException  extends Exception{

	public DBException(String message) {
		super(message);
	}
	
	public DBException(String message, Throwable t) {
		super(message,t);
	}
}
