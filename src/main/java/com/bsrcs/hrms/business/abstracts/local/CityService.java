package com.bsrcs.hrms.business.abstracts.local;

import java.util.List;

import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.entities.concretes.local.City;

public interface CityService {
	
	DataResult<List<City>> findAllCities();
	
	DataResult<City> findById(int id);
}
