package com.masai.service;

import java.util.List;

import com.masai.exception.DriverException;
import com.masai.model.Driver;

public interface DriverService {

	public Driver insertDriver(Driver driver) throws DriverException;

}
