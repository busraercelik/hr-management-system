package com.bsrcs.hrms.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bsrcs.hrms.business.abstracts.UserCheckService;
import com.bsrcs.hrms.dataAccess.abstracts.JobSeekerDao;
import com.bsrcs.hrms.entities.concretes.JobSeeker;
import com.bsrcs.hrms.entities.concretes.User;

import lombok.extern.log4j.Log4j2;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Log4j2
@Service
public class MernisServiceAdapter implements UserCheckService{

	@Autowired
	private JobSeekerDao jobSeekerDao;
	
	@Override
	public boolean isRealPerson(User user) {
		
		JobSeeker jobSeeker = jobSeekerDao.findById(user.getId()).orElse(null);
		if (jobSeeker == null) {
			return false;
		}
		
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		boolean flag = false;
		
		try {
			flag = client.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getIdentityNo()),
					jobSeeker.getFname(),
					jobSeeker.getLname(), 
					Integer.parseInt(jobSeeker.getYearOfBirth()));
		} catch(Exception e) {
			log.error(e.getMessage());
		}
		
		return flag;
	}

}
