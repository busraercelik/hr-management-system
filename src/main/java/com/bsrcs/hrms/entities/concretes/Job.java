package com.bsrcs.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "jobs")
public class Job {
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "job_title")
	private String jobTitle;
	@Column(name = "description")
	private String description;
}
