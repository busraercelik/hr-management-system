package com.bsrcs.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsrcs.hrms.business.abstracts.VerificationCodeService;
import com.bsrcs.hrms.core.utilities.results.ErrorDataResult;
import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.core.utilities.results.SuccessDataResult;
import com.bsrcs.hrms.core.utilities.validations.RandomCodeGenerator;
import com.bsrcs.hrms.dataAccess.abstracts.EmailVerificationDao;
import com.bsrcs.hrms.entities.concretes.EmailVerificationCode;
import java.util.Optional;

@Service
public class VerificationCodeManager implements VerificationCodeService{

	@Autowired
	private EmailVerificationDao emailVerificationDao;
	
	
	@Override
	public void generateCode(EmailVerificationCode code, Integer id) {
	
		boolean flag = code.isEnabled();
		
		if(id != null && code.isEnabled() == false) {
			String generatedCode = RandomCodeGenerator.getRandomCode();
			code.setVerificationCode(generatedCode);
			code.setId(id);
			
			emailVerificationDao.save(code);
		}
		
	}

	@Override
	public Result verify(String verificationCode, Integer id) {
		Optional<EmailVerificationCode> value =  emailVerificationDao.findById(id);
		
		EmailVerificationCode ref = null;
		if (value.isPresent()) {
			ref = value.get();
		}
		
		if (ref!= null && ref.getVerificationCode().equals(verificationCode)) {
			return new SuccessDataResult<EmailVerificationCode>("Success");
		} else {
			return new ErrorDataResult<EmailVerificationCode>("Invalid code! :(");
		}
	}

}
