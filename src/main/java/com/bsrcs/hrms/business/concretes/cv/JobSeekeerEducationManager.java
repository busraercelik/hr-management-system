package com.bsrcs.hrms.business.concretes.cv;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bsrcs.hrms.business.abstracts.cv.JobSeekerCVService;
import com.bsrcs.hrms.business.abstracts.cv.JobSeekerEducationService;
import com.bsrcs.hrms.business.rules.BusinessRuleService;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.ErrorDataResult;
import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.core.utilities.results.SuccessDataResult;
import com.bsrcs.hrms.dataAccess.abstracts.cv.JobSeekerEducationDao;
import com.bsrcs.hrms.entities.concretes.cv.JobSeekerEducation;
import com.bsrcs.hrms.entities.dtos.JobSeekerEducationAddDTO;

@Service
public class JobSeekeerEducationManager implements JobSeekerEducationService {
	
	private JobSeekerEducationDao educationDao;
	private BusinessRuleService businessRuleService;
	private JobSeekerCVService cvService;
	private ModelMapper mapper;
	
	@Autowired
	public JobSeekeerEducationManager(JobSeekerEducationDao educationDao,BusinessRuleService businessRuleService,
			JobSeekerCVService cvService,ModelMapper mapper) {
		this.educationDao = educationDao;
		this.businessRuleService = businessRuleService;
		this.cvService = cvService;
		this.mapper = mapper;
	}

	@Override
	public boolean existsByJobSeekeerCVIdAndTechnologyName(int id, int courseId, String degreeId) {
		return educationDao.existsByJobSeekerCVIdAndCourseIdAndDegree(id, courseId, degreeId);
	}

	@Override
	public Result addEducation(JobSeekerEducationAddDTO educationAddDTO) {
		JobSeekerEducation ed = new JobSeekerEducation();
		mapper.map(educationAddDTO, ed);
		educationDao.save(ed);
		return new SuccessDataResult<>();
	}

	@Override
	public DataResult<List<JobSeekerEducation>> findAllByJobSeekerCVIdOrderByGraduationDateDesc(int cvId) {
		
		Result res = businessRuleService.checkBooleanVal(cvService.existsById(cvId), "There is no cv with given id");
	
		if (res.isSuccess()) {
			return new SuccessDataResult<>(educationDao.findAllByJobSeekerCVIdOrderByGraduationDateDesc(cvId));
		}
		return new ErrorDataResult<>();
	}

}
