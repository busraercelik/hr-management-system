package com.bsrcs.hrms.business.concretes.cv;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsrcs.hrms.business.abstracts.cv.JobSeekerCVService;
import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.core.utilities.results.SuccessResult;
import com.bsrcs.hrms.dataAccess.abstracts.cv.JobSeekerCVDao;
import com.bsrcs.hrms.entities.concretes.cv.JobSeekerCV;
import com.bsrcs.hrms.entities.dtos.JobSeekerCVDTO;

@Service
public class JobSeekerCVManager implements JobSeekerCVService{

	private JobSeekerCVDao cvDao;
	private ModelMapper mapper;
	
	@Autowired
	public JobSeekerCVManager(JobSeekerCVDao cvDao,ModelMapper mapper) {
		this.cvDao = cvDao;
		this.mapper = mapper;
	}

	@Override
	public boolean existsById(int id) {
		return cvDao.existsById(id);
	}

	@Override
	public Result add(JobSeekerCVDTO cvdto) {
		JobSeekerCV cv = new JobSeekerCV();
		mapper.map(cvdto, cv);
		cvDao.save(cv);
		return new SuccessResult("Jobseeker cv is created");
	}

}
