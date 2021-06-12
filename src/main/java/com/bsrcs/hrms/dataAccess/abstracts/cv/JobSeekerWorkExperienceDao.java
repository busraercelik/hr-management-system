package com.bsrcs.hrms.dataAccess.abstracts.cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bsrcs.hrms.entities.concretes.cv.JobSeekerWorkExperience;

public interface JobSeekerWorkExperienceDao extends JpaRepository<JobSeekerWorkExperience, Integer> {
	//boolean existByJobSeekerCvIdAndCompanyNameAndJobPositionId(int jobSeekerCvId, 
	//														String companyName, int jobPositionId);
	
	@Query("FROM JobSeekerWorkExperience jse where jse.id=:id "
			+ "ORDER BY jse.leavingDate DESC")
	List<JobSeekerWorkExperience> findByJobSeekerCvIdOrderByLeavingDateDesc(int id);
}	
