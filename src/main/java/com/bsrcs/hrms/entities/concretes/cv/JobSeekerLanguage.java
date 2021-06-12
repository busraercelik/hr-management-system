package com.bsrcs.hrms.entities.concretes.cv;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bsrcs.hrms.entities.concretes.local.Language;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "jobseeker_languages")
public class JobSeekerLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name = "langauge_id")
	private Language language;
	
	private byte levelOfLanguage;
	
	@ManyToOne
	@JoinColumn(name = "jobseeker_cv_id")
	private JobSeekerCV jobSeekerCV;
}
