package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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




	@Override
	public Driver updateDriver(Driver driver) throws DriverException {
		
		Optional<Driver> opt = driverDao.findById(driver.getDriverId());
		if(opt.isPresent()) {
			
			driverDao.save(driver);
			return driver;
		}else {
			throw new DriverException("Driver does not exist..");
		}
		
	}




	@Override
	public Driver deleteDriver(Integer driverId) throws DriverException {
		Optional<Driver> opt = driverDao.findById(driverId);
		
		if(opt.isPresent()) {
			Driver existDriver  = opt.get();
			driverDao.delete(existDriver);
			return existDriver;
		}else {
			throw new DriverException("Driver Id does not exist");
		}
	
	}


	@Override
	public Driver viewDriver(Integer driverId) throws DriverException {
		
		Optional<Driver> opt = driverDao.findById(driverId);
		if(opt.isPresent()) {
			
			Driver existDriver = opt.get();
			return existDriver;
		}else {
			throw new DriverException("Invalid DriverId");
		}
	
	}
	
	

	@Override
	public List<Driver> viewBestDriver() throws DriverException {
		
		List<Driver> allDrivers = driverDao.findAll();
		List<Driver> drivers = new ArrayList<>();
		
		for(Driver driver : allDrivers) {
			if(driver.getRating() >= 4.5) {
				
				drivers.add(driver);
			}
		}
		
		if(drivers.isEmpty()) {
			throw new DriverException("No Drivers found rating above 4.5");
		}
		return drivers;
	}



	@Override
	public Driver rateDriverByCustomer(Driver driver) throws DriverException {
		
		Driver rateDriver = driverDao.findById(driver.getDriverId())
				.orElseThrow(() -> new DriverException("No driver found"));

		
		if (rateDriver.getRating() != 0) {

			Float newRating = (driver.getRating() + rateDriver.getRating()) / 2;

			rateDriver.setRating(newRating);

			return driverDao.save(rateDriver);

		} else {

			rateDriver.setRating(driver.getRating());

			return driverDao.save(rateDriver);

		}	
		
	}	
}
