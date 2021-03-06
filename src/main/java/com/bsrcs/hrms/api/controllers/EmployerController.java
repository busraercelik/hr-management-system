package com.bsrcs.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bsrcs.hrms.business.abstracts.EmployerService;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("employer/")
public class EmployerController {
	
	@Autowired
	private EmployerService employerService;
	
	@GetMapping(value = "employerList")
	DataResult<List<Employer>> getAll() {
		return employerService.getAllEmployers();
	}
	
	@PostMapping(value = "add")
	ResponseEntity<?> addEmployer(Employer employer) {
		return ResponseEntity.ok(employerService.addEmployer(employer));
	}
	
}
