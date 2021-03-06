package com.bsrcs.hrms.business.abstracts.local;

import java.util.List;

import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.entities.concretes.local.Faculty;

public interface FacultyService {
	DataResult<List<Faculty>> findByUniversityId(Integer id);
}
