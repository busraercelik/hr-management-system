package com.bsrcs.hrms.business.abstracts.cv;

import java.util.List;

import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.entities.concretes.cv.JobSeekerEducation;
import com.bsrcs.hrms.entities.dtos.JobSeekerEducationAddDTO;

public interface JobSeekerEducationService {
	Result addEducation(JobSeekerEducationAddDTO educationAddDTO);
	
	boolean existsByJobSeekeerCVIdAndTechnologyName(int id, int courseId, String degreeId);
	
	DataResult<List<JobSeekerEducation>> findAllByJobSeekerCVIdOrderByGraduationDateDesc(int cvId);
}
