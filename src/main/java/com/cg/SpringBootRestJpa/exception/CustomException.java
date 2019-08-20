package com.cg.SpringBootRestJpa.exception;

public class CustomException extends Exception {
	public CustomException() {
		super();
	}

	public CustomException(String msg) {
		super(msg);
	}

}