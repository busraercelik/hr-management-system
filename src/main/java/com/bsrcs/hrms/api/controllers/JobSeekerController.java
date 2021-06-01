package com.bsrcs.hrms.api.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bsrcs.hrms.business.abstracts.JobSeekerService;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.entities.concretes.JobSeeker;


@RestController
@RequestMapping("user/")
public class JobSeekerController {

	private JobSeekerService jobSeekerService;
	
	@Autowired
	public JobSeekerController(JobSeekerService jobSeekerService) {
		this.jobSeekerService = jobSeekerService;
	}
	
	@GetMapping("candidateList")
	DataResult<List<JobSeeker>> getAll() {
		return jobSeekerService.getAll();
	}
	
	
}
