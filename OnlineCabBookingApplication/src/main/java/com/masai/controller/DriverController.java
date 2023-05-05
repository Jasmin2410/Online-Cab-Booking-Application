package com.masai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Driver;
import com.masai.service.CabService;
import com.masai.service.DriverService;

import jakarta.validation.Valid;

@RestController
public class DriverController {

//	@Autowired
//	private TripBookingService tripBookingService;
	
	@Autowired
	private CabService cabServices;
	
	@Autowired
	private DriverService driverService;

	@PostMapping("/adddriver")
	public ResponseEntity<Driver> addDriver(@Valid @RequestBody Driver driver){
		
		Driver saved  = driverService.insertDriver(driver);
		
		return new ResponseEntity<Driver>(saved, HttpStatus.ACCEPTED);
	}

}
