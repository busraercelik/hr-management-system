package com.bsrcs.hrms.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.notification.UnableToSendNotificationException;
import org.springframework.stereotype.Service;

import com.bsrcs.hrms.business.abstracts.JobSeekerService;
import com.bsrcs.hrms.business.abstracts.UserCheckService;
import com.bsrcs.hrms.dataAccess.abstracts.JobSeekerDao;
import com.bsrcs.hrms.entities.concretes.JobSeeker;

import lombok.extern.log4j.Log4j2;
import net.bytebuddy.utility.RandomString;

@Log4j2
@Service
public class JobSeekerManager implements JobSeekerService{

	@Autowired
	private JobSeekerDao userDao;
	@Autowired
	private UserCheckService userCheckService;

	@Override
	public List<JobSeeker> getAll() {
		return userDao.findAll();
	}

	@Override
	public JobSeeker getUser(int id) {
		Optional<JobSeeker> user = userDao.findById(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			log.error("There is no user with id: {}", id);
			return null;
		}
	}

	@Override
	public void registerJobSeeker(JobSeeker user) {
		
		userCheckService.isRealPerson(user);
		checkEmailAndIdentityNo(user);
		
		try {
			user.setEnabled(false);
			
			// create random string
			String randomCode = RandomString.make(64);
			user.setCreatedTime(new java.util.Date());
			user.setVerificationCode(randomCode);
		
			userDao.save(user);
			
		} catch(Exception e) {
			log.error("UserDao failed -> upsert(): {} ", e.getMessage());
		}
	}

	@Override
	public String sendVerificationEmail(JobSeeker user, String code) {
		System.out.println("Please verify your registration!");
		String mailContent = "Dear "+user.getFname()+" "+user.getLname()+", ";
		mailContent += "Please click the link below to verify to your registration: ";
		mailContent += "VERIFY";
		System.out.println(mailContent);
		if (code.equals(user.getVerificationCode())) {
			user.setEnabled(true);
			return "Your mail is successfully verified";
		}
		return "Could not verify your email! :(";
	}

	@Override
	public void delete(int id) {
		try {
			userDao.deleteById(id);
		} catch(Exception e) {
			log.error("UserDao failed -> delete(): {} ", e.getMessage());
		}
	}
	
	public void checkEmailAndIdentityNo(JobSeeker user) {
		for(JobSeeker userInDb: getAll()) {
			if(user.getEmail().equals(userInDb.getEmail())) {
				log.info("User with "+user.getEmail()+" is already exist!");
				return;
			}			
			else if (user.getIdentityNo().equals(userInDb.getIdentityNo())) {
				log.info("User with "+user.getIdentityNo()+" is already exist!");
				return;
			}
		}
	}


	public String isEmailValid(String email) throws Exception {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		
		if (matcher.matches()) {
			return email;
		} else {
			throw new UnableToSendNotificationException("Invalid email format!");
		}
	}
	
}
