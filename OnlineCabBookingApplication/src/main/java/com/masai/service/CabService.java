package com.masai.service;

import java.util.List;

import com.masai.exception.DriverException;
import com.masai.model.Cab;

public interface CabService {

		public Cab updateCab(Cab cab) throws DriverException;
		
		public List<Cab> viewCabsOfType(String carType) throws DriverException;
		
		public int countCabsOfType(String carType) throws DriverException;
}
