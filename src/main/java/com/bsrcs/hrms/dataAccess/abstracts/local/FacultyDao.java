package com.bsrcs.hrms.dataAccess.abstracts.local;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsrcs.hrms.entities.concretes.local.Faculty;

public interface FacultyDao extends JpaRepository<Faculty, Integer> {
	List<Faculty> findByUniversityId(Integer id);
}
