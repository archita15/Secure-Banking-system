/**
 * 
 */
package com.group9.bankofaz.service;
import java.security.SecureRandom;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group9.bankofaz.dao.UserOtpDAO;
import com.group9.bankofaz.dao.UserOtpDAOImpl;
import com.group9.bankofaz.dao.UsersDAO;
import com.group9.bankofaz.model.UserOtp;
import com.group9.bankofaz.model.Users;
import com.warrenstrange.googleauth.GoogleAuthenticator;
import com.warrenstrange.googleauth.GoogleAuthenticatorKey;
import com.warrenstrange.googleauth.KeyRepresentation;
import com.warrenstrange.googleauth.GoogleAuthenticatorConfig;


import com.group9.bankofaz.component.BOASendMail;

/**
 * @authors Archita Palkar
 *
 */

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private BOASendMail boaSendEmail;

	@Autowired
	private UsersDAO usersDao;

	@Autowired
	private UserOtpDAO userOtpDao;

	private SecureRandom secureRandom;

	// Email OTP validity (you can change this as you like)
	private static final long OTP_VALIDITY_MILLIS = TimeUnit.MINUTES.toMillis(5);

	@PostConstruct
	public void initIt() {
		secureRandom = new SecureRandom();
	}
	

	@Override
	public int generateOTP(String username) {
		final GoogleAuthenticatorKey key = gAuth.createCredentials(username);
		return key.getVerificationCode();
	}

	@Override
	public void sendEmail(String emailId, String message, String subject) {
		boaSendEmail.SendMailToCustomer(emailId, subject, message);
	}

	@PostConstruct
	public void initIt() throws Exception {
		configBuilder = new GoogleAuthenticatorConfigBuilder().setTimeStepSizeInMillis(TimeUnit.SECONDS.toMillis(30))
				.setWindowSize(50).setKeyRepresentation(KeyRepresentation.BASE64);
		config = configBuilder.build();
		gAuth = new GoogleAuthenticator(config);
		userOtpDao = new UserOtpDAOImpl();
	}

	@Override
	public void updateLoginInfo(Users users) {
		usersDao.update(users);
	}
	
	@Override
	public String generatePassword() {
		return RandomStringUtils.randomAlphanumeric(10);

	}
}
