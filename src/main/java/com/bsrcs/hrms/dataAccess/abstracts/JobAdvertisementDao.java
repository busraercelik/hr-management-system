package com.bsrcs.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bsrcs.hrms.entities.concretes.JobAdvertisement;
import com.bsrcs.hrms.entities.dtos.ActiveJobAdvertisementDTO;

@Repository
public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	@Query("select new com.bsrcs.hrms.entities.dtos.ActiveJobAdvertisementDTO"
			+ "(e.companyName,p.jobTitle,a.noOfOpenPosition,a.publishedDate,a.applicationDeadline) "
			+ "from Employer e inner join e.advertisements a inner join a.jobPosition p "
			+ "where a.isActive = true "
			+ "order by a.publishedDate")
	List<ActiveJobAdvertisementDTO> findAllByIsActiveAndOrderByDate();
	
	@Query("select new com.bsrcs.hrms.entities.dtos.ActiveJobAdvertisementDTO"
			+ "(e.companyName,p.jobTitle,a.noOfOpenPosition,a.publishedDate,a.applicationDeadline) "
			+ "from Employer e inner join e.advertisements a inner join a.jobPosition p "
			+ "where a.isActive = true")
	List<ActiveJobAdvertisementDTO> findAllByIsActive();
	
	
	List<JobAdvertisement> findAllByIsActiveTrueAndEmployer_CompanyNameContainsIgnoreCase(String companyName);
	
	
}
