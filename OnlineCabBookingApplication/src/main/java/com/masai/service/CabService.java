package com.masai.service;

import java.util.List;

import com.masai.exception.CabException;

import com.masai.model.Cab;

public interface CabService {
	

	public Cab insertCab(Cab cab) throws CabException;

	public Cab updateCab(Cab cab) throws CabException;

	public Cab deleteCab(int cabId) throws CabException;

	public List<Cab> viewCabsOfType(String carType) throws CabException;

	public int countCabsOfType(String carType);

	
}
