package com.bsrcs.hrms.api.controllers.cv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsrcs.hrms.business.abstracts.cv.JobSeekerEducationService;
import com.bsrcs.hrms.entities.concretes.cv.JobSeekerEducation;

@RestController
@RequestMapping(value = "jobseeker-education")
public class JobSeekerEducationController {

	private JobSeekerEducationService educationService;

	@Autowired
	public JobSeekerEducationController(JobSeekerEducationService educationService) {
		this.educationService = educationService;
	}
	
	
}
