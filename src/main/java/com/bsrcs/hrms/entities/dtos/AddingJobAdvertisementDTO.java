package com.bsrcs.hrms.entities.dtos;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddingJobAdvertisementDTO {
	// 1 den düşük değer gelirse hata fırlatır
	@Min(1)
	private int employerId;
	@Min(1)
	private int jobId;
	@Min(1)
	@Max(81)
	private int cityId;
	private Double minSalary;
	private Double maxSalary;
	private LocalDate applicationDeadline;
	private String noOfOpenPosition;
}
