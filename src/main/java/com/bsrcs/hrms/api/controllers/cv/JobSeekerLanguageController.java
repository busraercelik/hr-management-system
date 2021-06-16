package com.bsrcs.hrms.api.controllers.cv;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bsrcs.hrms.business.abstracts.cv.JobSeekerLanguageService;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.entities.concretes.cv.JobSeekerLanguage;
import com.bsrcs.hrms.entities.dtos.JobSeekerLanguageAddDTO;


@RestController
@RequestMapping(path = "jobseeker-language")
public class JobSeekerLanguageController {
	 
	private JobSeekerLanguageService languageService;

	@Autowired
	public JobSeekerLanguageController(JobSeekerLanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	
	@PostMapping("/add")
	 public ResponseEntity<Result> add(@RequestBody @Valid JobSeekerLanguageAddDTO addDTO) {
		
			Result result = languageService.add(addDTO);
		if (result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	 }
	
	@GetMapping("/findAllLanguagesOfPerson/{id}")
	public ResponseEntity<DataResult<List<JobSeekerLanguage>>> findAllLanguagesOfPerson(@PathVariable int id) {
		return new ResponseEntity<>(languageService.findAllLanguagesOfPerson(id), HttpStatus.OK);
	}
}
