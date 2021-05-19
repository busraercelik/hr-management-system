package com.bsrcs.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bsrcs.hrms.business.abstracts.EmployerService;
import com.bsrcs.hrms.dataAccess.abstracts.EmployerDao;
import com.bsrcs.hrms.dataAccess.abstracts.JobDao;
import com.bsrcs.hrms.entities.concretes.Employer;
import com.bsrcs.hrms.entities.concretes.Job;

@Service
public class EmployerManager implements EmployerService {
	
	@Autowired
	private EmployerDao employerDao;
	@Autowired
	private JobDao jobDao;

	@Override
	public void registerEmployer(Employer employer) {
		employerDao.save(employer);
	}

	@Override
	public List<Employer> getAllEmployers() {
		return employerDao.findAll();
	}

	@Override
	public String getJobTitleOfEmployer(Employer employer) {
		Job job = jobDao.findById(employer.getId()).orElse(null);
		String jobTitle = "Employer's title is: "+job.getJobTitle();
		return jobTitle;
	}
	
	public String getDomain(String email) {
		String delimiter = "@";
		String[] temp = email.split(delimiter);

		return temp[1];
	}

}
