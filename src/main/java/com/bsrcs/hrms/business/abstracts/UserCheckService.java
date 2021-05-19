package com.bsrcs.hrms.business.abstracts;

import com.bsrcs.hrms.entities.concretes.User;

public interface UserCheckService {
	boolean isRealPerson(User user);
}
