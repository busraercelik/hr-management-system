package com.bsrcs.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "job_seekers")
public class JobSeeker extends User{
	@Id
	@Column(name = "user_id")
	private int id;
	
	@Column(name = "job_seeker_name")
	private String fname;
	
	@Column(name = "job_seeker_surname")
	private String lname;
	
	@Column(name = "identity_no")
	private String identityNo;
	
	@Column(name = "year_of_birth")
	private String yearOfBirth;
}
