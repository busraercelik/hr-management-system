package com.bsrcs.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employers")
public class Employer extends User{
	
	@Id
	@Column(name = "user_id")
	private int id;
	@Column(name = "company_name")
	private String companyName;
	@Column(name = "web_site")
	private String website;
}
