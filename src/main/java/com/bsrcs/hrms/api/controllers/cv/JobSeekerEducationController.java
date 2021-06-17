package com.bsrcs.hrms.api.controllers.cv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsrcs.hrms.business.abstracts.cv.JobSeekerEducationService;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.entities.concretes.cv.JobSeekerEducation;
import com.bsrcs.hrms.entities.dtos.JobSeekerEducationAddDTO;

@RestController
@RequestMapping(value = "jobseeker-education")
public class JobSeekerEducationController {

	private JobSeekerEducationService educationService;

	@Autowired
	public JobSeekerEducationController(JobSeekerEducationService educationService) {
		this.educationService = educationService;
	}
	
	@PostMapping("/addEducation")
	public ResponseEntity<Result> addEducation(JobSeekerEducationAddDTO educationAddDTO) {
		return new ResponseEntity<>(educationService.addEducation(educationAddDTO), HttpStatus.OK);
	}
	
	@GetMapping("/findAllByJobSeekerCVIdOrderByGraduationDateDesc")
	public ResponseEntity<DataResult<List<JobSeekerEducation>>> findAllByJobSeekerCVIdOrderByGraduationDateDesc(int cvId) {
		DataResult<List<JobSeekerEducation>> result = educationService.findAllByJobSeekerCVIdOrderByGraduationDateDesc(cvId);
		
		if (result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
	}
		
}
