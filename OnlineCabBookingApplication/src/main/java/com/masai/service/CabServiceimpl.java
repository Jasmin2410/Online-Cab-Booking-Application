package com.masai.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.DriverException;
import com.masai.model.Cab;
import com.masai.model.Driver;
import com.masai.repository.DriverDao;

@Service
public class CabServiceimpl implements CabService {

	@Autowired
	private DriverDao driverDao;	
	
	
	
	
	@Override
	public Cab updateCab(Cab cab) throws DriverException {
		List<Driver> drivers = driverDao.findAll();

		boolean flag = false;

		for (Driver driver : drivers) {
			if (driver.getCab().getCabId() == cab.getCabId()) {
				Cab updateCab = driver.getCab();
				updateCab.setCarType(cab.getCarType());
				updateCab.setPerKmRate(cab.getPerKmRate());
				flag = true;

				driverDao.save(driver);
			}
		}
		if (!flag)
			throw new DriverException("No driver found having cab with id " + cab.getCabId());

		else
			return cab;
	}
	
	
	

	@Override
	public List<Cab> viewCabsOfType(String carType) throws DriverException {
		List<Cab> cabs = new ArrayList<>();

		for (Driver driver : driverDao.findAll()) {
			if (driver.getCab().getCarType().equalsIgnoreCase(carType)) {
				cabs.add(driver.getCab());
			}
		}
		if (cabs.isEmpty())
			throw new DriverException("No driver has cab of type " + carType);
		else
			return cabs;
	}

	
	
	
	@Override
	public int countCabsOfType(String carType) throws DriverException {

		int count = 0;

		for (Driver driver : driverDao.findAll()) {
			if (driver.getCab().getCarType().equalsIgnoreCase(carType)) {
				count++;
			}
		}
		if (count == 0)
			throw new DriverException("No driver has cab of type " + carType);
		else
			return count;
	}


}
