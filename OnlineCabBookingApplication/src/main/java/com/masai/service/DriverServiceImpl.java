package com.masai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.DriverException;
import com.masai.model.Driver;
import com.masai.repository.AdminDao;
import com.masai.repository.DriverDao;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverDao driverDao;

	
	@Autowired
	private AdminDao adminDao;

	
	
	
	@Override
	public Driver insertDriver(Driver driver) throws DriverException {

		Driver existDriver = driverDao.findByUserName(driver.getUserName());

		if (existDriver != null)
			throw new DriverException("Driver Registered with user ID ");

		return driverDao.save(driver);
	}

	
	

}
