package com.bsrcs.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jobs")
public class JobPosition {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "job_title")
	private String jobTitle;
}
