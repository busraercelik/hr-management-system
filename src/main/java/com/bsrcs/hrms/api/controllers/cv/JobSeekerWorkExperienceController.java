package com.bsrcs.hrms.api.controllers.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsrcs.hrms.business.abstracts.cv.JobSeekerWorkExperienceService;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.entities.concretes.cv.JobSeekerWorkExperience;


@RestController
@RequestMapping(value = "workExperience")
public class JobSeekerWorkExperienceController {
	
	private JobSeekerWorkExperienceService experienceService;

	@Autowired
	public JobSeekerWorkExperienceController(JobSeekerWorkExperienceService experienceService) {
		super();
		this.experienceService = experienceService;
	}
	
	@GetMapping(value = "/findAll")
	public ResponseEntity<?> findAllWorkExperienceOfAJobSeeker(@PathVariable int jobseekerCvId) {
		DataResult<List<JobSeekerWorkExperience>> experiences = experienceService.findAllWorkExperienceOfAJobSeeker(jobseekerCvId);
		
		if (experiences.isSuccess()) {
			return ResponseEntity.ok(experiences);
		}
		
		return ResponseEntity.badRequest().body(experiences);
	}
	
	@GetMapping(value = "/orderWorkExperience")
	public ResponseEntity<?> orderWorkExperienceByDate(@PathVariable int id) {
		DataResult<List<JobSeekerWorkExperience>> experiences = experienceService.orderWorkExperienceByDate(id);
		
		if (experiences.isSuccess()) {
			return ResponseEntity.ok(experiences);
		}
		return ResponseEntity.badRequest().body(experiences);
	}
	
}
