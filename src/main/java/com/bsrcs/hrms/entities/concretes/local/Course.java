package com.bsrcs.hrms.entities.concretes.local;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	private String courseName;
	
	@ManyToOne
	@JoinColumn(name = "faculty_id")
	@JsonIgnoreProperties("university")
	private Faculty faculty;
	
	@ManyToOne
	@JoinColumn(name = "university_id")
	@JsonIgnoreProperties("city")
	private University university;
}
