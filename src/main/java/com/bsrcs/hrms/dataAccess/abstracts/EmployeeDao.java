package com.bsrcs.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bsrcs.hrms.entities.concretes.Employer;

@Repository
public interface EmployeeDao extends JpaRepository<Employer, Integer>{

}
