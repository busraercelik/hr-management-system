package com.bsrcs.hrms.api.controllers.local;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bsrcs.hrms.business.abstracts.local.CourseService;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.entities.concretes.local.Course;


@RestController
@RequestMapping(value = "course")
public class CourseController {
	
	private CourseService courseService;

	@Autowired
	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}
	
	@GetMapping(value = "/findAllCoursesByFacultyId")
	public ResponseEntity<?> findAllCoursesByFacultyId(Integer id) {
		DataResult<List<Course>> courses = courseService.findAllCoursesByFacultyId(id);
		if (courses.isSuccess()) {
			return ResponseEntity.ok(courses);
		}
		return ResponseEntity.badRequest().body(courses);
	}
	
}
