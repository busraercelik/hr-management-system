package com.bsrcs.hrms.business.concretes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.bsrcs.hrms.business.abstracts.CityService;
import com.bsrcs.hrms.dataAccess.abstracts.CityDao;
import com.bsrcs.hrms.entities.concretes.City;

public class CityManager implements CityService{

	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public City findById(int id) {
		return cityDao.findById(id).orElse(null); 
	}

}
