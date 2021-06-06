package com.bsrcs.hrms.business.abstracts;

import com.bsrcs.hrms.entities.concretes.City;

public interface CityService {
	City findById(int id);
}
