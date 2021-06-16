package com.bsrcs.hrms.business.concretes.cv;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsrcs.hrms.business.abstracts.cv.JobSeekerTechnologyService;
import com.bsrcs.hrms.business.rules.BusinessRuleService;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.ErrorDataResult;
import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.core.utilities.results.SuccessDataResult;
import com.bsrcs.hrms.core.utilities.validations.UserValidator;
import com.bsrcs.hrms.dataAccess.abstracts.cv.JobSeekerTechnologyDao;
import com.bsrcs.hrms.entities.concretes.cv.JobSeekerEducation;
import com.bsrcs.hrms.entities.concretes.cv.JobSeekerTechnology;
import com.bsrcs.hrms.entities.dtos.JobSeekerTechnologyAddDTO;

@Service
public class JobSeekerTechnologyManager implements JobSeekerTechnologyService{

	private JobSeekerTechnologyDao jobSeekerTechnologyDao;
	private BusinessRuleService businessRuleService;
	private ModelMapper mapper;
	
	@Autowired
	public JobSeekerTechnologyManager(JobSeekerTechnologyDao jobSeekerTechnologyDao, 
			BusinessRuleService businessRuleService, ModelMapper mapper) {
		this.jobSeekerTechnologyDao = jobSeekerTechnologyDao;
		this.businessRuleService = businessRuleService;
		this.mapper = mapper;
	}

	@Override
	public Result addTechnology(JobSeekerTechnologyAddDTO educationAddDTO) {
		Result cvResult = businessRuleService
						.checkBooleanVal(jobSeekerTechnologyDao
						.existsById(educationAddDTO.getJobSeekerCVId()), "No cv found by given id");
		
		Result technologyResult = businessRuleService.checkBooleanVal(jobSeekerTechnologyDao
				.existsByJobSeekerCVIdAndTechnologyName(educationAddDTO.getJobSeekerCVId(), 
						educationAddDTO.getTechnologyName()), "This technology is already in your cv");
		
		Result result = UserValidator.run(cvResult, technologyResult);
		
		if (result.isSuccess()) {
			JobSeekerEducation education = new JobSeekerEducation();
			mapper.map(educationAddDTO, education);
			return new SuccessDataResult<>(education);
		}
		
		return new ErrorDataResult<>(result.getMessage());
	}

	@Override
	public boolean existsByJobSeekerCVIdAndTechnologyName(int id, String technologyName) {
		return jobSeekerTechnologyDao.existsByJobSeekerCVIdAndTechnologyName(id, technologyName);
	}

	@Override
	public DataResult<List<JobSeekerTechnology>> getAllEducationOfJobSeeker(int id) {
		Result res = businessRuleService.checkBooleanVal(jobSeekerTechnologyDao.existsById(id), 
				"There is no record with given id");
		if (res.isSuccess()) {
			return new SuccessDataResult<>(jobSeekerTechnologyDao.findAllByJobSeekerCVId(id));
		}
		
		return new ErrorDataResult<>(res.getMessage());
	}

}
