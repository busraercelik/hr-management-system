package com.bsrcs.hrms.entities.dtos;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActiveJobAdvertisementDTO {
	private String companyName;
	private String jobTitle;
	private String noOfOpenPositions;
	private LocalDate publishedDate;
	private LocalDate applicationDeadline;
}
