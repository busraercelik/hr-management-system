package com.bsrcs.hrms.entities.concretes.cv;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "jobseeker_cvs")
public class JobSeekerCV {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jobseeker_cv_id")
	private int id;
	
	private String githubLink;
	
	private String linkedinLink;
	
	private String photoLink;
	
	private boolean isActive = true;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "jobSeekerCV")
	@JsonIgnoreProperties("jobSeekerCV")
	private List<JobSeekerEducation> jobSeekerEducations = new ArrayList<>();
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "jobSeekerCV")
	@JsonIgnoreProperties("jobSeekerCV")
	private List<JobSeekerWorkExperience> workExperiences = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "jobSeekerCV")
	@JsonIgnoreProperties("jobSeekerCV")
	private List<JobSeekerLanguage> languages = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "jobSeekerCV")
	@JsonIgnoreProperties("jobSeekerCV")
	private List<JobSeekerTechnology> technologies = new ArrayList<>();
}
