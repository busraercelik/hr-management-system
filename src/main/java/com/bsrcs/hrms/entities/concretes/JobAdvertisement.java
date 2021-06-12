package com.bsrcs.hrms.entities.concretes;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.bsrcs.hrms.entities.concretes.local.City;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_advertisements")
public class JobAdvertisement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "job_description")
	private String jobDescription;
	
	@Column(name = "no_of_open_position")
	private String noOfOpenPosition;
	
	@Column(name = "min_salary")
	private Double minSalary;
	
	@Column(name = "max_salary")
	private Double maxSalary;
	
	@Column(name = "published_date")
	private LocalDate publishedDate = LocalDate.from(ZonedDateTime.now());
	
	@Column(name = "application_deadline")
	private LocalDate applicationDeadline;
	
	@Column(name = "is_active")
	private boolean isActive = true;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private Employer employer;
}
