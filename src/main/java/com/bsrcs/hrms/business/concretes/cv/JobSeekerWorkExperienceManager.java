package com.bsrcs.hrms.business.concretes.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsrcs.hrms.business.abstracts.cv.JobSeekerWorkExperienceService;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.ErrorDataResult;
import com.bsrcs.hrms.core.utilities.results.SuccessDataResult;
import com.bsrcs.hrms.dataAccess.abstracts.cv.JobSeekerWorkExperienceDao;
import com.bsrcs.hrms.entities.concretes.cv.JobSeekerWorkExperience;

@Service
public class JobSeekerWorkExperienceManager implements JobSeekerWorkExperienceService{

	private JobSeekerWorkExperienceDao experienceDao;
	
	@Autowired
	public JobSeekerWorkExperienceManager(JobSeekerWorkExperienceDao experienceDao) {
		super();
		this.experienceDao = experienceDao;
	}

	@Override
	public DataResult<List<JobSeekerWorkExperience>> findAllWorkExperienceOfAJobSeeker(int id) {
		return new SuccessDataResult<>(experienceDao.findAllByJobSeekerCVId(id),"Candidate's work experience is listed");
	}

	@Override
	public DataResult<List<JobSeekerWorkExperience>> orderWorkExperienceByDate(int id) {
		if (experienceDao.existsById(id)) {
			return new SuccessDataResult<>(experienceDao.findByJobSeekerCvIdOrderByLeavingDateDesc(id));
		}
		return new ErrorDataResult<>("There is no cv for this candidate!");
	}

}
