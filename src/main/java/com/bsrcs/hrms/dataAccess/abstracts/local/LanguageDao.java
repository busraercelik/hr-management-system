package com.bsrcs.hrms.dataAccess.abstracts.local;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bsrcs.hrms.entities.concretes.local.Language;

@Repository
public interface LanguageDao extends JpaRepository<Language, Integer> {

}
