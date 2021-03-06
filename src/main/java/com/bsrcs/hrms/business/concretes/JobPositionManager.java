package com.bsrcs.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsrcs.hrms.business.abstracts.JobPositionService;
import com.bsrcs.hrms.core.utilities.constants.RegistrationConstants;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.ErrorResult;
import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.core.utilities.results.SuccessDataResult;
import com.bsrcs.hrms.core.utilities.results.SuccessResult;
import com.bsrcs.hrms.dataAccess.abstracts.JobPositionDao;
import com.bsrcs.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	private final JobPositionDao jobDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobDao) {
		this.jobDao = jobDao;
	}
	
	@Override
	public DataResult<List<JobPosition>> getAllJobPositons() {
		return new SuccessDataResult<List<JobPosition>>(jobDao.findAll()," Listed successfully!");
	}

	@Override
	public Result addJobPosition(JobPosition jobPosition) {
		jobDao.save(jobPosition);
		return new SuccessResult(RegistrationConstants.registrationAndVerificationCode);
	}

	@Override
	public Result isJobPositionExist(int id) {
		
		if (jobDao.existsById(id)) {
			return new SuccessResult();
		}
		return new ErrorResult("Job Position does not exist!");
	}

	@Override
	public JobPosition findById(int id) {
		return jobDao.findById(id).orElse(null);
	}
	
	

}
