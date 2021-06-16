package com.bsrcs.hrms.dataAccess.abstracts.cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsrcs.hrms.entities.concretes.cv.JobSeekerLanguage;

public interface JobSeekerLanguageDao extends JpaRepository<JobSeekerLanguage, Integer> {
	boolean existsByJobSeekerCV_IdAndLanguage_Id(int jobSeekerCvId, int languageId);
	
	List<JobSeekerLanguage> findAllByJobSeekerCVId(int id);
}
