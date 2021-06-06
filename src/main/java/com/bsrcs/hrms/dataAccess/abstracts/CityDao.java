package com.bsrcs.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsrcs.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {

}
