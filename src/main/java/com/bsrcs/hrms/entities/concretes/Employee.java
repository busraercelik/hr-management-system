package com.bsrcs.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "employees")
public class Employee extends User{
	@Id
	@Column(name = "user_id")
	private int id;
	
	@Column(name = "employee_name")
	private String fname;
	
	@Column(name = "employee_surname")
	private String lname;
}
