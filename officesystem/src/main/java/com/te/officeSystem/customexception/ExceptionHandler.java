package com.te.officeSystem.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.officeSystem.response.Response;

@RestControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(CustomException.class)
	public ResponseEntity<Response> handler(CustomException e) {
		return new ResponseEntity<Response>(new Response(true, e.getMessage(), null), HttpStatus.BAD_REQUEST);
	}
}
