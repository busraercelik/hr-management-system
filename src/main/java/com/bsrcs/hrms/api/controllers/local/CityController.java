package com.bsrcs.hrms.api.controllers.local;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsrcs.hrms.business.abstracts.local.CityService;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.entities.concretes.local.City;

@RestController
@RequestMapping(value = "city")
public class CityController {

	private CityService cityService;

	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	
	@GetMapping(value = "/findAllCities")
	public ResponseEntity<?> findAllCities() {
		return ResponseEntity.ok(cityService.findAllCities());
	}
	
	@GetMapping(value = "/findById")
	public ResponseEntity<?> findById(int id) {
		DataResult<City> city = cityService.findById(id);
		
		if (city.isSuccess()) {
			return ResponseEntity.ok(city);
		}
		return ResponseEntity.badRequest().body(city);
	}
	
}
