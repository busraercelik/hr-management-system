package com.bsrcs.hrms.dataAccess.abstracts.local;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsrcs.hrms.entities.concretes.local.Language;

public interface LanguageDao extends JpaRepository<Language, Integer> {

}
