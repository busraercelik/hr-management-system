package com.bsrcs.hrms.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T>{

	public ErrorDataResult() {
		super(null, false);
	}
	
	public ErrorDataResult(T data) {
		super(data, false);
	}

	
	public ErrorDataResult(String message) {
		super(null, false, message);
	}
}
