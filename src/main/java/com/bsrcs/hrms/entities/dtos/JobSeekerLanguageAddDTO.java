package com.bsrcs.hrms.entities.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JobSeekerLanguageAddDTO {
	
	@Min(1)
	@NotNull
	private int languageId;
	
	@Min(1)
	@Max(5)
	private byte levelOfLanguage;
	
	@Min(1)
	@NotNull
	private int jobSeekerCvId;
}
