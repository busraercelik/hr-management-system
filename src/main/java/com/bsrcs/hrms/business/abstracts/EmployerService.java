package com.bsrcs.hrms.business.abstracts;

import java.util.List;

import com.bsrcs.hrms.entities.concretes.Employer;

public interface EmployerService {
	void registerEmployer(Employer employer);
	List<Employer> getAllEmployers();
	String getJobTitleOfEmployer(Employer employer);
}
