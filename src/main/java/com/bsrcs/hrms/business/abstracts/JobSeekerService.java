package com.bsrcs.hrms.business.abstracts;

import java.util.List;
import com.bsrcs.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	List<JobSeeker> getAll();
	JobSeeker getUser(int id);
	void registerJobSeeker(JobSeeker user);
	void delete(int id);
	String sendVerificationEmail(JobSeeker user, String code);
}
