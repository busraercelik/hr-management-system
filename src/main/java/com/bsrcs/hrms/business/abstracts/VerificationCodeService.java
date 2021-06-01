package com.bsrcs.hrms.business.abstracts;

import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.entities.concretes.EmailVerificationCode;

public interface VerificationCodeService {
	void generateCode(EmailVerificationCode code, Integer id);
	Result verify(String verificationCode, Integer id);
}
