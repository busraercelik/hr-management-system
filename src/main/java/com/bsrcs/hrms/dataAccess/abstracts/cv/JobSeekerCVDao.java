package com.bsrcs.hrms.dataAccess.abstracts.cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsrcs.hrms.entities.concretes.cv.JobSeekerCV;

public interface JobSeekerCVDao extends JpaRepository<JobSeekerCV, Integer>{
	List<JobSeekerCV> findByIdAndIsActiveTrue(int id);
}
