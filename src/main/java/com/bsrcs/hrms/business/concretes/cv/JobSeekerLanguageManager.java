package com.bsrcs.hrms.business.concretes.cv;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsrcs.hrms.business.abstracts.cv.JobSeekerCVService;
import com.bsrcs.hrms.business.abstracts.cv.JobSeekerLanguageService;
import com.bsrcs.hrms.business.abstracts.local.LanguageService;
import com.bsrcs.hrms.business.rules.BusinessRuleService;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.core.utilities.results.SuccessDataResult;
import com.bsrcs.hrms.core.utilities.results.SuccessResult;
import com.bsrcs.hrms.dataAccess.abstracts.cv.JobSeekerLanguageDao;
import com.bsrcs.hrms.entities.concretes.cv.JobSeekerLanguage;
import com.bsrcs.hrms.entities.dtos.JobSeekerLanguageAddDTO;

@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService {

	private JobSeekerLanguageDao languageDao;
	private ModelMapper modelmapper;
	private LanguageService languageService;
	private BusinessRuleService businessRuleService;
	private JobSeekerCVService cvService;
	
	@Autowired
	public JobSeekerLanguageManager(JobSeekerLanguageDao languageDao,ModelMapper modelmapper,
			BusinessRuleService businessRuleService,JobSeekerCVService cvService) {
		this.languageDao = languageDao;
		this.modelmapper = modelmapper;
		this.businessRuleService = businessRuleService;
		this.cvService = cvService;
	}

	@Override
	public Result add(JobSeekerLanguageAddDTO addDTO) {
		
		businessRuleService.checkBooleanVal(cvService.existsById(addDTO.getJobSeekerCvId()),
				"There is no cv with given id");
		
		//boolean isExists = languageService.existsById(addDTO.getLanguageId());
		//businessRuleService.checkBooleanVal(isExists, "There is no such language with given id");
		
		JobSeekerLanguage jobSeekerLanguage = new JobSeekerLanguage();
		modelmapper.map(addDTO, jobSeekerLanguage);
		
		languageDao.save(jobSeekerLanguage);
		
		return new SuccessResult("Language added!");
	}

	@Override
	public DataResult<List<JobSeekerLanguage>> findAllLanguagesOfPerson(int id) {
		return new SuccessDataResult<>(languageDao.findAllByJobSeekerCVId(id));
	}

}
