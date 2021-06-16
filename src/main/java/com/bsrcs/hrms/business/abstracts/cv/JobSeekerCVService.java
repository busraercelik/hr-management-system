package com.bsrcs.hrms.business.abstracts.cv;

import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.entities.dtos.JobSeekerCVDTO;

public interface JobSeekerCVService {
	
	Result add(JobSeekerCVDTO cvdto);
	
	boolean existsById(int id);
}
