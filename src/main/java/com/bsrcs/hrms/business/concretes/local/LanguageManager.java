package com.bsrcs.hrms.business.concretes.local;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsrcs.hrms.business.abstracts.local.LanguageService;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.core.utilities.results.SuccessDataResult;
import com.bsrcs.hrms.dataAccess.abstracts.local.LanguageDao;
import com.bsrcs.hrms.entities.concretes.local.Language;

@Service
public class LanguageManager implements LanguageService{

	private LanguageDao dao;
	
	@Autowired
	public LanguageManager(LanguageDao dao) {
		this.dao = dao;
	}

	@Override
	public DataResult<List<Language>> findAllLanguages() {
		return new SuccessDataResult<List<Language>>(dao.findAll());
	}

	

}
