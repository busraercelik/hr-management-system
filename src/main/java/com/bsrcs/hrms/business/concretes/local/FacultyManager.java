package com.bsrcs.hrms.business.concretes.local;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsrcs.hrms.business.abstracts.local.FacultyService;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.ErrorDataResult;
import com.bsrcs.hrms.core.utilities.results.SuccessDataResult;
import com.bsrcs.hrms.dataAccess.abstracts.local.FacultyDao;
import com.bsrcs.hrms.entities.concretes.local.Faculty;

@Service
public class FacultyManager implements FacultyService{

	private FacultyDao facultyDao;
	
	@Autowired
	public FacultyManager(FacultyDao facultyDao) {
		super();
		this.facultyDao = facultyDao;
	}


	@Override
	public DataResult<List<Faculty>> findByUniversityId(Integer id) {
		List<Faculty> faculties = facultyDao.findByUniversityId(id);
		if (faculties.isEmpty()) {
			return new ErrorDataResult<List<Faculty>>("There is no such faculty at given university id");
		}
		return new SuccessDataResult<List<Faculty>>(faculties);
	}

}
