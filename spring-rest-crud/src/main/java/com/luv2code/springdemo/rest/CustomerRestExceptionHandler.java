package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exception) {
		CustomerErrorResponse body = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value()
				,exception.getMessage(),System.currentTimeMillis());
		return new ResponseEntity<CustomerErrorResponse>(body, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception exception) {
		CustomerErrorResponse body = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value()
				,exception.getMessage(),System.currentTimeMillis());
		return new ResponseEntity<CustomerErrorResponse>(body, HttpStatus.BAD_REQUEST);
	}
}
