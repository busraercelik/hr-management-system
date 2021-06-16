package com.bsrcs.hrms.core.utilities.validations;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bsrcs.hrms.core.utilities.results.ErrorDataResult;

@ControllerAdvice
public class Handler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String,String> validationErrors = new HashMap<>();
		
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		return new ErrorDataResult<>(validationErrors,"Validation errors");
	}
}
