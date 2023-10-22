package com.java.interview.sprint.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.java.interview.sprint.exception.BadRequestException;
import com.java.interview.sprint.exception.BusinessException;

@ControllerAdvice
public class ExceptionHandlingAdvice {
	
	
	 @ExceptionHandler(value = {BadRequestException.class})
	   public ResponseEntity<Object> handleBadRequestException(Exception ex) {
	        return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.BAD_REQUEST);
	    }
	 
	
	 
	 @ExceptionHandler(value = {BusinessException.class})
	   public ResponseEntity<Object> handleBusinessException(Exception ex) {
	        return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	
	
	  @ExceptionHandler(value = { Exception.class })
	   public ResponseEntity<Object> handleException(Exception ex) {
	        return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	     

}
