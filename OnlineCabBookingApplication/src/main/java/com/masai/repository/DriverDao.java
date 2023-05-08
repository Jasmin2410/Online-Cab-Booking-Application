package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.model.Driver;
import com.masai.model.DriverDTO;

@Repository
public interface DriverDao extends JpaRepository<Driver, Integer> {

	public Driver findByUserName(String userName);
	
	@Query("select new com.masai.model.DriverDTO(d.userName,d.password) from Driver d")
	public DriverDTO findDriverUserNamePassword(String userName, String password);

}
