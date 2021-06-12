package com.bsrcs.hrms.dataAccess.abstracts.cv;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsrcs.hrms.entities.concretes.cv.JobSeekerLanguage;

public interface JobSeekerLanguageDao extends JpaRepository<JobSeekerLanguage, Integer> {
	//boolean existByJobSeekerCv_IdAndLanguage_Id(int jobSeekerCvId, int languageId);
}
