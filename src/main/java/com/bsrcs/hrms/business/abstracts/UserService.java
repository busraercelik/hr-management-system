package com.bsrcs.hrms.business.abstracts;

import com.bsrcs.hrms.entities.concretes.User;

public interface UserService {
	User findByEmail(String email);
}
