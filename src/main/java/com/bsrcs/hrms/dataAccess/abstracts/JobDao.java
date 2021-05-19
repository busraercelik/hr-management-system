package com.bsrcs.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bsrcs.hrms.entities.concretes.Job;

@Repository
public interface JobDao extends JpaRepository<Job, Integer>{

}
