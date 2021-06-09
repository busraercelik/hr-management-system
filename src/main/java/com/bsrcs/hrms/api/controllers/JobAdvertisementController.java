package com.bsrcs.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bsrcs.hrms.business.abstracts.JobAdvertisementService;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.entities.concretes.JobAdvertisement;
import com.bsrcs.hrms.entities.dtos.ActiveJobAdvertisementDTO;
import com.bsrcs.hrms.entities.dtos.AddingJobAdvertisementDTO;

@RestController
@RequestMapping(value = "jobAdvertisement/")
public class JobAdvertisementController {

	private JobAdvertisementService advertisementService;
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService advertisementService) {
		super();
		this.advertisementService = advertisementService;
	}

	@GetMapping(value = "getAllActive")
	public DataResult<List<ActiveJobAdvertisementDTO>> findAllByIsActive(){
		return advertisementService.findAllByIsActive();
	}
	
	@PostMapping(value = "add")
	public Result addJobAdvertisementByEmployer(@RequestBody @Valid AddingJobAdvertisementDTO dto) {
		return advertisementService.addJobAdvertisementByEmployer(dto);
	}
	
	@GetMapping(value = "sortActiveJobsByDate")
	DataResult<List<ActiveJobAdvertisementDTO>> findActiveJobsSortedByDate() {
		return advertisementService.findActiveJobsSortedByDate();
	}
	
	@GetMapping(value = "sortActiveJobsByCompany")
	DataResult<List<JobAdvertisement>> findByCompanyAndActive(@RequestParam("companyName") String companyName){
		return advertisementService.findByCompanyAndActive(companyName);
	}
	
	@PostMapping(value = "switchActiveJobToPassive")
	public ResponseEntity<?> switchActiveJobToPassive(int id) {
		Result result = advertisementService.switchActiveJobToPassive(id);
		
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.badRequest().body(result);
		}
		
	}
}
