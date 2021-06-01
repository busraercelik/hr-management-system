package com.bsrcs.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsrcs.hrms.business.abstracts.JobPositionService;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.SuccessDataResult;
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

}
