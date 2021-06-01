package com.bsrcs.hrms.dataAccess.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsrcs.hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {
	List<JobSeeker> getByIdentityNo(String idNo);
	
	Optional<JobSeeker> findByEmail(String email);
}
