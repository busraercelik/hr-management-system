package com.bsrcs.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bsrcs.hrms.business.abstracts.UserService;
import com.bsrcs.hrms.dataAccess.abstracts.UserDao;
import com.bsrcs.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

}
