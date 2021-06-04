package com.bsrcs.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsrcs.hrms.adapters.MernisServiceAdapter;
import com.bsrcs.hrms.business.abstracts.*;
import com.bsrcs.hrms.core.utilities.constants.RegistrationConstants;
import com.bsrcs.hrms.core.utilities.results.*;
import com.bsrcs.hrms.core.utilities.validations.UserValidator;
import com.bsrcs.hrms.dataAccess.abstracts.JobSeekerDao;
import com.bsrcs.hrms.entities.concretes.EmailVerificationCode;
import com.bsrcs.hrms.entities.concretes.JobSeeker;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class JobSeekerManager implements JobSeekerService{
	
	private JobSeekerDao userDao;
	private UserCheckService userCheckService;
	private VerificationCodeService verificationCodeService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao userDao,UserCheckService userCheckService,
								VerificationCodeService verificationCodeService) {
		this.userDao = userDao;
		this.userCheckService = userCheckService;
		this.verificationCodeService = verificationCodeService;
	}
	
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(userDao.findAll(),"All job seeker list");
	}

	@Override
	public DataResult<JobSeeker> getCandidate(int id) {
		return new SuccessDataResult<JobSeeker>(userDao.getOne(id));
	}


	@Override
	public Result delete(int id) {
		try {
			userDao.deleteById(id);
		} catch(Exception e) {
			log.error("UserDao failed -> delete(): {} ", e.getMessage());
			return new ErrorResult("UserDao failed -> delete()");
		}
		return new SuccessResult("User is successfully deleted!");
	}
	

	public Result isEmailValid(String email) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		
		if (matcher.matches()) {
			return new SuccessResult("Valid email");
		} else {
			return new ErrorResult(RegistrationConstants.isMailValid);
		}
	}

	@Override
	public Result update(JobSeeker seeker) {
		try {
			userDao.save(seeker);
		} catch(Exception e) {
			log.error("UserDao failed -> delete(): {} ", e.getMessage());
			return new ErrorResult("UserDao failed -> update()");
		}
		return new SuccessResult(seeker.getFname() + " is successfully updated!");
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		
		Result result = UserValidator.run(firstNameChecker(jobSeeker.getFname()),
				lastNameChecker(jobSeeker.getLname()),
				mernisChecker(jobSeeker),
				isIdNoRegisteredBefore(jobSeeker.getIdentityNo()),
				birthDateChecker(jobSeeker.getYearOfBirth()),
				emailChecker(jobSeeker.getEmail()),
				isEmailValid(jobSeeker.getEmail()),
				passwordChecker(jobSeeker.getPassword()),
				isMailRegisteredBefore(jobSeeker.getEmail())
				);
		
		if(!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		 
		JobSeeker user = userDao.save(jobSeeker);
		verificationCodeService.generateCode(new EmailVerificationCode(), user.getId());
		return new SuccessResult(RegistrationConstants.registrationAndVerificationCode);
	}
	
	private Result firstNameChecker(String fName) {
		if(fName.equals("") || fName.equals(null)) {
			return new ErrorResult(RegistrationConstants.requiredFirstName);
		}
		return new SuccessResult();
	}
	
	private Result lastNameChecker(String lName) {
		if(lName.equals("") || lName.equals(null)) {
			return new ErrorResult(RegistrationConstants.requiredLastName);
		}
		return new SuccessResult();
	}
	
	private Result birthDateChecker(String birthDay) {
		if(birthDay.equals(null)) {
			return new ErrorResult(RegistrationConstants.requiredBirthDate);
		}
		return new SuccessResult();
	}
	
	private Result emailChecker(String email) {
		if(email.equals("") || email.equals(null)) {
			return new ErrorResult(RegistrationConstants.requiredEmail);
		}
		return new SuccessResult();
	}
	
	private Result passwordChecker(String password) {
		if(password.equals("") ||password.equals(null)) {
			return new ErrorResult(RegistrationConstants.requiredPassword);
		}
		return new SuccessResult();
	}
	
	private Result idNoChecker(String idNo) {
		if(idNo.equals("") ||idNo.equals(null) || idNo.length() != 11) {
			return new ErrorResult(RegistrationConstants.requiredIdNo);
		}
		return new SuccessResult();
	}
	
	private Result isMailRegisteredBefore(String email) {
		
		if(userDao.findByEmail(email).isPresent()) {
			return new ErrorResult(RegistrationConstants.alreadyRegisteredMail);
		}
		return new SuccessResult();
	}
	
	private Result isIdNoRegisteredBefore(String idNo) {
		
		if(userDao.getByIdentityNo(idNo).stream().count() != 0) {
			return new ErrorResult(RegistrationConstants.alreadyRegisteredId);
		}
		return new SuccessResult();
	}
	
	private Result mernisChecker(JobSeeker jobSeeker) {
		if (userCheckService.isRealPerson(jobSeeker)) {
			return new SuccessResult();
		}
		return new ErrorResult("Verification is failed!");
	}
}
