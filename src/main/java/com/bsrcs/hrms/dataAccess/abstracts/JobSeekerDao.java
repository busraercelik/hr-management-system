package com.bsrcs.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsrcs.hrms.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer> {

}
