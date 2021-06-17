package com.bsrcs.hrms.entities.dtos;

import java.util.Date;

import lombok.Data;

@Data
public class JobSeekerEducationAddDTO {

	private String educationLevel;
	
	private String gpa;
	
	private Date entryDate;
	
	private Date graduationDate;
	
	private String degree;
}
