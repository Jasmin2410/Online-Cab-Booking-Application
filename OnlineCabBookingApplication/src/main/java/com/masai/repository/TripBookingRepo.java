package com.masai.repository;

import com.masai.model.TripBooking;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripBookingRepo extends JpaRepository<TripBooking, Integer> {
	List<TripBooking> findByFromDateTime(LocalDateTime date);
}
