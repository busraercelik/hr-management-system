package com.bsrcs.hrms.business.abstracts.cv;

import java.util.List;

import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.entities.concretes.cv.JobSeekerWorkExperience;

public interface JobSeekerWorkExperienceService {
	DataResult<List<JobSeekerWorkExperience>> findAllWorkExperienceOfAJobSeeker(int id);
	
	DataResult<List<JobSeekerWorkExperience>> orderWorkExperienceByDate(int id);
}
