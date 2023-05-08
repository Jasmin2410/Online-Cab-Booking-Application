package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.DriverException;
import com.masai.model.Cab;
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
		
		return new ResponseEntity<>(saved, HttpStatus.ACCEPTED);
	}

	
	@PutMapping("/updateDriver")
	public ResponseEntity<Driver> updateDriver(@Valid @RequestBody Driver driver){
		
		Driver updateDriver =  driverService.updateDriver(driver);
	    return new ResponseEntity<>(updateDriver, HttpStatus.ACCEPTED);
	
	}
	
	
	@DeleteMapping("/deleteDriver/{driverId}")
	public ResponseEntity<Driver> deleteDriver(@PathVariable("driverId") Integer driverId){
		Driver deleteDriver = driverService.deleteDriver(driverId);
		
		return new ResponseEntity<>(deleteDriver, HttpStatus.OK);
	}
	
	
	@GetMapping("/viewdriver/{did}")
	public ResponseEntity<Driver> viewDriver(@PathVariable("did") Integer driverId) throws DriverException{
		
		Driver viewdriver = driverService.viewDriver(driverId);
		
		return new ResponseEntity<Driver>(viewdriver, HttpStatus.OK);
		
	}

	
	@GetMapping("/viewBestDrivers")
	public ResponseEntity<List<Driver>> viewBestDriver(){
		
		List<Driver> drivers = driverService.viewBestDriver();
		
		return new ResponseEntity<>(drivers, HttpStatus.OK);
	}


	@PutMapping("/rateDriverByCustomer")
	public ResponseEntity<Driver> rateDriverByCustomer(@Valid @RequestBody Driver driver){
		
		Driver rateDriver =  driverService.rateDriverByCustomer(driver);
	    return new ResponseEntity<>(rateDriver, HttpStatus.ACCEPTED);
	
	}
	
	
//	cab servises
	
	@PutMapping("/drivers/updateCab")
	public ResponseEntity<Cab> updateCab(@Valid @RequestBody Cab cab) throws DriverException{
		
		Cab updatedCab = cabServices.updateCab(cab);
		
		return new ResponseEntity<Cab>(updatedCab, HttpStatus.ACCEPTED);
	}

	
	@GetMapping("/viewCabsOfType/{carType}")
	public ResponseEntity<List<Cab>> viewCabsOfType(@PathVariable("carType") String carType){
		
		List<Cab> cabs = cabServices.viewCabsOfType(carType);
		
		return new ResponseEntity<>(cabs, HttpStatus.OK);
	}
	
	@GetMapping("/countCabsOfType/{carType}")
	public Integer countCabsOfType(@PathVariable("carType") String carType){
		
		int count = cabServices.countCabsOfType(carType);
		
		return count;
	}
	
}
