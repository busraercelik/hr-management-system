package com.bsrcs.hrms.dataAccess.abstracts.cv;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.entities.concretes.cv.JobSeekerEducation;

public interface JobSeekerEducationDao extends JpaRepository<JobSeekerEducation, Integer> {
	
	@Query("FROM JobSeekerEducation where jobSeekerCV.id =: id ORDER BY graduationDate DESC")
	List<JobSeekerEducation> findByJobSeekerId(int id);
	
	boolean existsByJobSeekerCVIdAndCourseIdAndDegree(int JobSeekerId, int courseId, String degree);
	
	List<JobSeekerEducation> findAllByJobSeekerCVIdOrderByGraduationDateDesc(int cvId);
}
