package com.bsrcs.hrms.business.concretes.local;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsrcs.hrms.business.abstracts.local.CityService;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.ErrorDataResult;
import com.bsrcs.hrms.core.utilities.results.SuccessDataResult;
import com.bsrcs.hrms.dataAccess.abstracts.local.CityDao;
import com.bsrcs.hrms.entities.concretes.local.City;

@Service
public class CityManager implements CityService{

	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<City> findById(int id) {
		Optional<City> city = cityDao.findById(id);
		
		if (city.isPresent()) {
			return new SuccessDataResult<City>(city.get()) ;
		}
		return new ErrorDataResult<City>("There is no city match with given id") ; 
	}

	@Override
	public DataResult<List<City>> findAllCities() {
		return new SuccessDataResult<List<City>>(cityDao.findAll());
	}

}
