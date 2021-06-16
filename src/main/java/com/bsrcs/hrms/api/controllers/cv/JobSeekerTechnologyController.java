package com.bsrcs.hrms.api.controllers.cv;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bsrcs.hrms.business.abstracts.cv.JobSeekerTechnologyService;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.entities.concretes.cv.JobSeekerTechnology;
import com.bsrcs.hrms.entities.dtos.JobSeekerEducationAddDTO;

@RestController
@RequestMapping(value = "jobseeker-technology")
public class JobSeekerTechnologyController {

	private JobSeekerTechnologyService technologyService;

	@Autowired
	public JobSeekerTechnologyController(JobSeekerTechnologyService jobSeekerTechnologyService) {
		this.technologyService = jobSeekerTechnologyService;
	}
	
	@PostMapping("/addTechnology")
	public ResponseEntity<Result> addTechnology(@RequestBody @Valid JobSeekerEducationAddDTO educationAddDTO) {
		return new ResponseEntity<>(technologyService.addTechnology(educationAddDTO), HttpStatus.OK);
	}
	
	@GetMapping("/getAllEducationOfJobSeeker/{id}")
	public ResponseEntity<DataResult<List<JobSeekerTechnology>>> getAllEducationOfJobSeeker(@RequestParam int id) {
		DataResult<List<JobSeekerTechnology>> dataResult = technologyService.getAllEducationOfJobSeeker(id);
		
		if (dataResult.isSuccess()) {
			return new ResponseEntity<>(dataResult,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	 
}
