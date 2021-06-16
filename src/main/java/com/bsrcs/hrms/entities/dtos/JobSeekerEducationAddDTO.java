package com.bsrcs.hrms.entities.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.bsrcs.hrms.entities.concretes.cv.JobSeekerCV;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobSeekerEducationAddDTO {

	@Size(min = 1, max = 100)
	@NotNull
	private String technologyName;

	@Min(1)
	@NotNull
	private int jobSeekerCVId;
}
