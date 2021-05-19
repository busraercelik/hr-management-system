package com.bsrcs.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bsrcs.hrms.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{

}
