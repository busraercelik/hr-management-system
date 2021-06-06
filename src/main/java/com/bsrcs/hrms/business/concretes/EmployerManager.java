package com.bsrcs.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bsrcs.hrms.business.abstracts.EmployerService;
import com.bsrcs.hrms.core.utilities.constants.RegistrationConstants;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.ErrorResult;
import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.core.utilities.results.SuccessDataResult;
import com.bsrcs.hrms.core.utilities.results.SuccessResult;
import com.bsrcs.hrms.dataAccess.abstracts.EmployerDao;
import com.bsrcs.hrms.entities.concretes.Employer;


@Service
public class EmployerManager implements EmployerService {
	
	@Autowired
	private EmployerDao employerDao;

	@Override
	public Result addEmployer(Employer employer) {
		employerDao.save(employer);
		return new SuccessResult(RegistrationConstants.registrationAndVerificationCode); 
	}

	@Override
	public DataResult<List<Employer>> getAllEmployers() {
		return new SuccessDataResult<List<Employer>>
		 (employerDao.findAll(), "All employer data is listed!");
	}

	
	public String getDomain(String email) {
		String delimiter = "@";
		String[] temp = email.split(delimiter);

		return temp[1];
	}
	
	@Override
	public Result isEmployerExist(int id) {
		
		if (employerDao.existsById(id)) {
			return new SuccessResult();
		}
		return new ErrorResult("Employer doesnot exist!");
	}

	@Override
	public Employer findById(int id) {
		return employerDao.findById(id).orElse(null);
	}


}
