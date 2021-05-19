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
	@Column(name = "created_time")
	private Date createdTime;
	// random, unique String which is generated in the registration process
	@Column(name = "verification_code", length = 64, updatable = false)
	private String verificationCode;
	// Once registered, the enabled status of a user is false (disabled) 
	@Column(name = "enabled")
	private boolean enabled;
}
