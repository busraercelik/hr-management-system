package com.bsrcs.hrms.business.abstracts;

import java.util.List;

import com.bsrcs.hrms.entities.concretes.Employee;

public interface EmployeeService {
	List<Employee> getAll();
}
