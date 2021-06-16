package com.bsrcs.hrms.business.rules;

import org.springframework.stereotype.Service;

import com.bsrcs.hrms.core.utilities.results.ErrorResult;
import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.core.utilities.results.SuccessResult;

@Service
public class BusinessRuleManager implements BusinessRuleService{

	@Override
	public Result checkBooleanVal(boolean value, String message) {
		if (value) {
			return new SuccessResult();
		}
		return new ErrorResult(message);
	}

}
