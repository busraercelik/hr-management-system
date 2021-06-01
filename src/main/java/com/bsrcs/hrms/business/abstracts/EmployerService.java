package com.bsrcs.hrms.business.abstracts;

import java.util.List;

import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.entities.concretes.Employer;

public interface EmployerService {
	void registerEmployer(Employer employer);
	DataResult<List<Employer>> getAllEmployers();
	DataResult<Employer> addEmployer();
}
