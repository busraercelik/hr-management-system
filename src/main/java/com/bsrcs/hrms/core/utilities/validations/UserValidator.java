package com.bsrcs.hrms.core.utilities.validations;

import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.core.utilities.results.SuccessResult;

public class UserValidator {
	
	// three dots, ... shortcut to creating an array manually (varargs)
	public static Result run(Result...results) {
		for(Result result: results) {
			if (!result.isSuccess()) {
				return result;
			}
		}
		
		return new SuccessResult();
	}
	
}
