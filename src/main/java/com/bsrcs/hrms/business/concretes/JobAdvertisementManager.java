package com.bsrcs.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bsrcs.hrms.business.abstracts.EmployerService;
import com.bsrcs.hrms.business.abstracts.JobAdvertisementService;
import com.bsrcs.hrms.business.abstracts.JobPositionService;
import com.bsrcs.hrms.business.abstracts.local.CityService;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.ErrorResult;
import com.bsrcs.hrms.core.utilities.results.Result;
import com.bsrcs.hrms.core.utilities.results.SuccessDataResult;
import com.bsrcs.hrms.core.utilities.results.SuccessResult;
import com.bsrcs.hrms.core.utilities.validations.UserValidator;
import com.bsrcs.hrms.dataAccess.abstracts.EmployerDao;
import com.bsrcs.hrms.dataAccess.abstracts.JobAdvertisementDao;
import com.bsrcs.hrms.dataAccess.abstracts.UserDao;
import com.bsrcs.hrms.entities.concretes.Employer;
import com.bsrcs.hrms.entities.concretes.JobAdvertisement;
import com.bsrcs.hrms.entities.concretes.JobPosition;
import com.bsrcs.hrms.entities.concretes.User;
import com.bsrcs.hrms.entities.concretes.local.City;
import com.bsrcs.hrms.entities.dtos.ActiveJobAdvertisementDTO;
import com.bsrcs.hrms.entities.dtos.AddingJobAdvertisementDTO;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao advertisementDao;
	private EmployerService employerService;
	private JobPositionService jobPositionService;
	private CityService cityService;
		
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao advertisementDao,EmployerService employerService,
			JobPositionService jobPositionService,CityService cityService) {
		super();
		this.advertisementDao = advertisementDao;
		this.employerService = employerService;
		this.jobPositionService = jobPositionService;
		this.cityService = cityService;
	}

	@Override
	public Result addJobAdvertisementByEmployer(AddingJobAdvertisementDTO advertisementDTO) {
		Result employerResult = employerService.isEmployerExist(advertisementDTO.getEmployerId());
		Result jobPositionResult = jobPositionService.isJobPositionExist(advertisementDTO.getJobId());
		
		Result result = UserValidator.run(employerResult
				,jobPositionResult
				,checkSalary(advertisementDTO.getMinSalary(), advertisementDTO.getMaxSalary()));
		
		if (!result.isSuccess()) {
			return result;
		}
		
		JobAdvertisement advertisement = setJobAdvertisementFieldsFromUserEntry(advertisementDTO);
		advertisementDao.save(advertisement);
		
		return new SuccessResult(advertisement.getJobPosition()+" position successfully added!");
	}

	private JobAdvertisement setJobAdvertisementFieldsFromUserEntry(AddingJobAdvertisementDTO advertisementDTO) {
		
		JobAdvertisement advertisement = new JobAdvertisement();
		Employer employer = employerService.findById(advertisementDTO.getEmployerId());
		DataResult<City> city = cityService.findById(advertisementDTO.getCityId());
		JobPosition jobPosition = jobPositionService.findById(advertisementDTO.getJobId());
		
		advertisement.setEmployer(employer);
		advertisement.setCity(city.getData());
		advertisement.setJobPosition(jobPosition);
		
		advertisement.setMinSalary(advertisementDTO.getMinSalary());
		advertisement.setMaxSalary(advertisementDTO.getMaxSalary());
		advertisement.setApplicationDeadline(advertisementDTO.getApplicationDeadline());
		
		return advertisement;
	}
	
	@Override
	public DataResult<List<ActiveJobAdvertisementDTO>> findAllByIsActive() {
		return new SuccessDataResult<List<ActiveJobAdvertisementDTO>>(advertisementDao.findAllByIsActive());
	}
	
	public Result checkSalary(Double minSalary, Double maxSalary) {
		
		if(minSalary > maxSalary) {
			return new ErrorResult("Min salary cannot be higher than max salary value!");
		}
		
		return new SuccessResult();
	}

	@Override
	public DataResult<List<ActiveJobAdvertisementDTO>> findActiveJobsSortedByDate() {
		List<ActiveJobAdvertisementDTO> activeJobAdvertisementDTOs =
					advertisementDao.findAllByIsActiveAndOrderByDate();
		return new SuccessDataResult<List<ActiveJobAdvertisementDTO>>(activeJobAdvertisementDTOs);
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByCompanyAndActive(String companyName) {
		return new SuccessDataResult(advertisementDao.findAllByIsActiveTrueAndEmployer_CompanyNameContainsIgnoreCase(companyName));
	}

	@Override
	public Result switchActiveJobToPassive(int id) {
		JobAdvertisement advertisement = advertisementDao.getOne(id);
		advertisement.setActive(false);
		advertisementDao.save(advertisement);
		return new SuccessResult();
	}
}
