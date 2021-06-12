package com.bsrcs.hrms.business.concretes.local;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsrcs.hrms.business.abstracts.local.CourseService;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.ErrorDataResult;
import com.bsrcs.hrms.core.utilities.results.SuccessDataResult;
import com.bsrcs.hrms.dataAccess.abstracts.local.CourseDao;
import com.bsrcs.hrms.entities.concretes.local.Course;

@Service
public class CourseManager implements CourseService{

	private CourseDao courseDao;
	
	@Autowired
	public CourseManager(CourseDao courseDao) {
		super();
		this.courseDao = courseDao;
	}

	@Override
	public DataResult<List<Course>> findAllCoursesByFacultyId(Integer id) {
		List<Course> courses = courseDao.findAllByFacultyId(id);
		
		if (courses.isEmpty()) {
			return new ErrorDataResult<List<Course>>("There is no course under given faculty");
		}
		return new SuccessDataResult<List<Course>>(courses);
	}

}
