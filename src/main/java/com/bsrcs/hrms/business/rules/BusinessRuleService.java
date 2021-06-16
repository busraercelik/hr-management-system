package com.bsrcs.hrms.business.rules;

import com.bsrcs.hrms.core.utilities.results.Result;

public interface BusinessRuleService {
	Result checkBooleanVal(boolean value, String message);
}
