package com.bsrcs.hrms.business.abstracts;

import java.util.List;

import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.entities.concretes.JobAdvertisement;
import com.bsrcs.hrms.entities.dtos.ActiveJobAdvertisementDTO;
import com.bsrcs.hrms.entities.dtos.AddingJobAdvertisementDTO;

public interface JobAdvertisementService {
	Result addJobAdvertisementByEmployer(AddingJobAdvertisementDTO advertisementDTO);
	
	DataResult<List<ActiveJobAdvertisementDTO>> findAllByIsActive();
	
	DataResult<List<ActiveJobAdvertisementDTO>> findActiveJobsSortedByDate();
	
	DataResult<List<JobAdvertisement>> findByCompanyAndActive(String companyName);
	
	Result switchActiveJobToPassive(int id);
}
