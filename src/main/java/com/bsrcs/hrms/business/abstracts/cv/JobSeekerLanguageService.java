package com.bsrcs.hrms.business.abstracts.cv;

import java.util.List;

import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.entities.concretes.cv.JobSeekerLanguage;
import com.bsrcs.hrms.entities.dtos.JobSeekerLanguageAddDTO;

public interface JobSeekerLanguageService {
	
	Result add(JobSeekerLanguageAddDTO addDTO);
	
	DataResult<List<JobSeekerLanguage>> findAllLanguagesOfPerson(int id);
}
