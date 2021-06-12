package com.bsrcs.hrms.entities.concretes.cv;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bsrcs.hrms.entities.concretes.local.Course;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "jobseeker_education")
public class JobSeekerEducation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "course_id")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name = "jobseeker_cv_id")
	private JobSeekerCV jobSeekerCV;
	
	private String educationLevel;
	
	private String gpa;
	
	private Date entryDate;
	
	private Date graduationDate;
	
	private String degree;

}
