package com.bsrcs.hrms.api.controllers.cv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsrcs.hrms.business.abstracts.cv.JobSeekerCVService;
import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.entities.dtos.JobSeekerCVDTO;

@RestController
@RequestMapping(value = "jobseeker-cv")
public class JobSeekerCVController {
	
	private JobSeekerCVService cvService;

	@Autowired
	public JobSeekerCVController(JobSeekerCVService cvService) {
		super();
		this.cvService = cvService;
	}
	
	@PostMapping(value = "/add")
	public ResponseEntity<Result> add(JobSeekerCVDTO cvdto) {
		return new ResponseEntity<>(cvService.add(cvdto), HttpStatus.OK);
	}
	
}
