package com.bsrcs.hrms.business.abstracts;

import java.util.List;

import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	DataResult<List<JobSeeker>> getAll();
	
	DataResult<JobSeeker> getCandidate(int id);
	
	Result add(JobSeeker jobSeeker);
	
	Result delete(int id);
	
	Result update(JobSeeker seeker);
}
