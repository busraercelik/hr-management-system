package com.bsrcs.hrms.dataAccess.abstracts.local;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsrcs.hrms.entities.concretes.local.Course;

public interface CourseDao extends JpaRepository<Course, Integer> {
	List<Course> findAllByFacultyId(Integer facultyId);
}
