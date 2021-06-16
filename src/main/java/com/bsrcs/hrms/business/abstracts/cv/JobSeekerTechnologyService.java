	package com.bsrcs.hrms.business.abstracts.cv;

import java.util.List;

import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.entities.concretes.cv.JobSeekerEducation;
import com.bsrcs.hrms.entities.concretes.cv.JobSeekerTechnology;
import com.bsrcs.hrms.entities.dtos.JobSeekerEducationAddDTO;

public interface JobSeekerTechnologyService {
	Result addTechnology(JobSeekerEducationAddDTO educationAddDTO);
	
	DataResult<List<JobSeekerTechnology>> getAllEducationOfJobSeeker(int id);
	
	boolean existsByJobSeekerCVIdAndTechnologyName(int id, String technologyName);
}
