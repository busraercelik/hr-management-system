package com.bsrcs.hrms.api.controllers.local;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsrcs.hrms.business.abstracts.local.LanguageService;
import com.bsrcs.hrms.core.utilities.results.DataResult;
import com.bsrcs.hrms.entities.concretes.local.Language;

@RestController
@RequestMapping(value = "language")
public class LanguageController {
	
	private LanguageService languageService;
	
	@Autowired
	public LanguageController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}

	@GetMapping(value = "/findAllLanguages")
	ResponseEntity<?> findAllLanguages() {
	DataResult<List<Language>> languages = languageService.findAllLanguages();
		if(languages.isSuccess()) {
			return ResponseEntity.ok(languages);
		}
		return ResponseEntity.badRequest().body("There is no foreign languge!");
	}
}
