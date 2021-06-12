package com.bsrcs.hrms.dataAccess.abstracts.local;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsrcs.hrms.entities.concretes.local.City;

public interface CityDao extends JpaRepository<City, Integer> {

}
