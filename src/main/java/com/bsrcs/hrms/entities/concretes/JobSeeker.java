package com.bsrcs.hrms.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "job_seekers")
@PrimaryKeyJoinColumn(name = "user_id")
public class JobSeeker extends User{
	
	@Column(name = "job_seeker_name")
	private String fname;
	
	@Column(name = "job_seeker_surname")
	private String lname;
	
	@Column(name = "identity_no")
	private String identityNo;
	
	@Column(name = "year_of_birth")
	private String yearOfBirth;
}
