package com.bsrcs.hrms.business.abstracts.local;

import java.util.List;

import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.entities.concretes.local.Course;

public interface CourseService {
	DataResult<List<Course>> findAllCoursesByFacultyId(Integer id);
}
