package com.masai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Customer;
import com.masai.model.TripBooking;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	List<TripBooking> findBycustomerID(Integer cId);
}
