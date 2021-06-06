package com.bsrcs.hrms.business.abstracts;

import java.util.List;

import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.entities.concretes.Employer;

public interface EmployerService {
	Result addEmployer(Employer employer);
	
	DataResult<List<Employer>> getAllEmployers();
	
	Result isEmployerExist(int id);
	
	Employer findById(int id);
}
