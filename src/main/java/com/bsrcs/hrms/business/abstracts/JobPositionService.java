package com.bsrcs.hrms.business.abstracts;

import java.util.List;

import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPosition>> getAllJobPositons();
	
	Result addJobPosition(JobPosition jobPosition);
}
