package com.bsrcs.hrms.entities.concretes.cv;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bsrcs.hrms.entities.concretes.JobPosition;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "jobseeker_work_experience")
public class JobSeekerWorkExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String companyName;
	
	private Date startingDate;
	
	private Date leavingDate;
	
	@OneToOne
	private JobPosition jobPosition;
	
	@ManyToOne
	@JoinColumn(name = "jobseeker_cv_id")
	private JobSeekerCV jobSeekerCV;
}
