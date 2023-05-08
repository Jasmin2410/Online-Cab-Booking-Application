package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LoginException;
import com.masai.model.CurrentSession;
import com.masai.model.LoginDTO;
import com.masai.repository.AdminDao;
import com.masai.repository.CurrentSessionDao;
import com.masai.repository.CustomerRepository;
import com.masai.repository.DriverDao;

@Service
public class LoginServiceImpl implements LoginService {


	@Autowired
	private DriverDao driverDao;

	@Autowired
	private CurrentSessionDao currentSessionDao;

	@Autowired
	private CustomerRepository customerDao;

	@Autowired
	private AdminDao admindao;
	
	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException {

		String type = dto.getUserType();
//
//		if (type.equals("customer")) {
//			Customer existingCustomer = customerDao.findByUserName(dto.getUserName());
//
//			if (existingCustomer == null)
//				throw new LoginException("Please enter a valid username ");
//
//			Optional<CurrentSession> validUserSessionOpt = currentSessionDao.findById(existingCustomer.getCustomerId());
//
//			if (validUserSessionOpt.isPresent()) {
//				throw new LoginException("User already logged in..");
//			}
//
//			if (!existingCustomer.getPassword().equals(dto.getPassword())) {
//				throw new LoginException("Please enter a valid password ");
//			}
//
//			UUID randomUUID = UUID.randomUUID();
//			String key = randomUUID.toString().split("-")[0];
//
//			CurrentSession userSession = new CurrentSession(existingCustomer.getCustomerId(), key, LocalDateTime.now());
//
//			currentSessionDao.save(userSession);
//
//			return userSession.toString();
//
//		} else if (type.equals("admin")) {
//			Admin existingAdmin = admindao.findByUserName(dto.getUserName());
//
//			if (existingAdmin == null)
//				throw new LoginException("Please enter a valid username ");
//
//			Optional<CurrentSession> validUserSessionOpt = currentSessionDao.findById(existingAdmin.getAdminID());
//
//			if (validUserSessionOpt.isPresent()) {
//				throw new LoginException("User already logged in..");
//			}
//
//			if (!existingAdmin.getPassword().equals(dto.getPassword())) {
//				throw new LoginException("Please enter a valid password ");
//
//			}
//
//			UUID randomUUID = UUID.randomUUID();
//			String key = randomUUID.toString().split("-")[0];
//
//			CurrentSession userSession = new CurrentSession(existingAdmin.getAdminID(), key, LocalDateTime.now());
//
//			currentSessionDao.save(userSession);
//
//			return userSession.toString();
//
//		} else if (type.equals("driver")) {
//
//			Driver existingDriver = driverDao.findByUserName(dto.getUserName());
//
//			if (existingDriver == null)
//				throw new LoginException("Please enter a valid username ");
//
//			Optional<CurrentSession> validUserSessionOpt = currentSessionDao.findById(existingDriver.getDriverId());
//
//			if (validUserSessionOpt.isPresent()) {
//				throw new LoginException("User already logged in..");
//			}
//
//			if (!existingDriver.getPassword().equals(dto.getPassword())) {
//				throw new LoginException("Please enter a valid password ");
//			}
//			UUID randomUUID = UUID.randomUUID();
//			String key = randomUUID.toString().split("-")[0];
//
//			CurrentSession userSession = new CurrentSession(existingDriver.getDriverId(), key, LocalDateTime.now());
//
//			currentSessionDao.save(userSession);
//
//			return userSession.toString();
//
//		}
//
//		else
			return "Usertype should be admin or customer or driver..";

	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		CurrentSession vs = currentSessionDao.findByUuid(key);
//		
//		if(vs==null) {
//			throw new LoginException("No user found with key " + key);
//		}else {
//			
//			currentSessionDao.delete(vs);
//			
			return "Logged Out!";
//		}
	}


}
