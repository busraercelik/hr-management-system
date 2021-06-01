package com.bsrcs.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bsrcs.hrms.business.abstracts.EmployeeService;
import com.bsrcs.hrms.dataAccess.abstracts.EmployeeDao;
import com.bsrcs.hrms.entities.concretes.Employee;

@Service
public class EmployeeManager implements EmployeeService{

	@Autowired
	private EmployeeDao empDao;
	
	@Override
	public List<Employee> getAll() {
		return empDao.findAll();
	}

}
