package com.bsrcs.hrms.dataAccess.abstracts.cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bsrcs.hrms.entities.concretes.cv.JobSeekerTechnology;

public interface JobSeekerTechnologyDao extends JpaRepository<JobSeekerTechnology, Integer>{
	
	@Query("FROM JobSeekerTechnology jst where jst.id=:id and jst.technologyName=:technologyName")
	List<JobSeekerTechnology> orderAllByLeavingDate(int id, String technologyName);
	
	List<JobSeekerTechnology> findAllByJobSeekerCVId(int id);
	
	boolean existsByJobSeekerCVIdAndTechnologyName(int id, String technologyName);
}
