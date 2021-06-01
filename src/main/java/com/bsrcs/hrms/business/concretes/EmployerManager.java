package com.bsrcs.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bsrcs.hrms.business.abstracts.EmployerService;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.SuccessDataResult;
import com.bsrcs.hrms.dataAccess.abstracts.EmployerDao;
import com.bsrcs.hrms.dataAccess.abstracts.JobPositionDao;
import com.bsrcs.hrms.entities.concretes.Employer;
import com.bsrcs.hrms.entities.concretes.JobPosition;

@Service
public class EmployerManager implements EmployerService {
	
	@Autowired
	private EmployerDao employerDao;
	@Autowired
	private JobPositionDao jobDao;

	@Override
	public void registerEmployer(Employer employer) {
		employerDao.save(employer);
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
	public DataResult<Employer> addEmployer() {
		// TODO Auto-generated method stub
		return null;
	}

}
