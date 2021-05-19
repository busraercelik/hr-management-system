package com.bsrcs.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsrcs.hrms.business.abstracts.JobSeekerService;
import com.bsrcs.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("user")
public class UserController {

	private JobSeekerService jobSeekerService;
	
	@Autowired
	public UserController(JobSeekerService jobSeekerService) {
		this.jobSeekerService = jobSeekerService;
	}
	
	@PostMapping("/create_jobseeker")
	public void createUser(JobSeeker jobSeeker, String code) {
		 jobSeekerService.registerJobSeeker(jobSeeker);
		 System.out.println("User is successfully created...");
		 System.out.println("Please check your email to verify your account...");
		 System.out.println(jobSeekerService.sendVerificationEmail(jobSeeker, code));
	}
}
