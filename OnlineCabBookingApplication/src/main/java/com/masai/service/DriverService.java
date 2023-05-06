package com.masai.service;

import java.util.List;

import com.masai.exception.DriverException;
import com.masai.model.Driver;

public interface DriverService {

	public Driver insertDriver(Driver driver) throws DriverException;

	public Driver updateDriver(Driver driver) throws DriverException;

	public Driver deleteDriver(Integer driverId) throws DriverException;

	public Driver viewDriver(Integer driverId) throws DriverException ;
	
	public List<Driver> viewBestDriver() throws DriverException;
	
	public Driver rateDriverByCustomer(Driver driver)throws DriverException;
}
