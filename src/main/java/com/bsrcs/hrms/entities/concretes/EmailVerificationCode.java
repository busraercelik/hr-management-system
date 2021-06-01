package com.bsrcs.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "verification_codes")
public class EmailVerificationCode {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "created_time")	
	private Date createdTime;
	
	// random, unique String which is generated in the registration process
	@Column(name = "verification_code", length = 64, updatable = false)
	private String verificationCode;
	
	// Once registered, the enabled status of a user is false (disabled) 
	@Column(name = "enabled")
	private boolean enabled;
	
	@Column(name = "user_id")
	private int userId;
}

