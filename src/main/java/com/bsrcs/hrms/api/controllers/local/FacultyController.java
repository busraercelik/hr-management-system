package com.bsrcs.hrms.api.controllers.local;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsrcs.hrms.business.abstracts.local.FacultyService;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.entities.concretes.local.Faculty;

@RestController
@RequestMapping(value = "faculty")
public class FacultyController {

	private FacultyService facultyService;

	@Autowired
	public FacultyController(FacultyService facultyService) {
		this.facultyService = facultyService;
	}
	
	@GetMapping(value = "/findByUniversityId")
	public ResponseEntity<?> findByUniversityId(Integer uniId) {
		DataResult<List<Faculty>> faculties = facultyService.findByUniversityId(uniId);
		
		if (faculties.isSuccess()) {
			return ResponseEntity.ok(faculties);
		}
		return ResponseEntity.badRequest().body(faculties.getMessage());
	}
	
}
