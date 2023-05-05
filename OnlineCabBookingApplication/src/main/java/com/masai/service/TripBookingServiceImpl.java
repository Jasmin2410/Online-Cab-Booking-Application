package com.masai.service;

import com.masai.exception.tripBooking.TripBookingException;
import com.masai.model.TripBooking;
import com.masai.repository.TripBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.Option;
import java.util.Optional;

public class TripBookingServiceImpl implements TripBookingService{

    @Autowired
    private TripBookingRepository tripBookingRepository;

    @Override
    public TripBooking insertTripBooking(TripBooking tb) {

        Optional<TripBooking> t1 = tripBookingRepository.findById(tb.getTripBookingId());

        if(!t1.isEmpty())
            throw new TripBookingException("Trip already exists");

        return tripBookingRepository.save(tb);
    }

    @Override
    public TripBooking updateTripBooking(TripBooking tb) {

        TripBooking t1 = tripBookingRepository.findById(tb.getTripBookingId()).orElseThrow(() -> new TripBookingException("Trip not found"));


        t1.setBill(tb.getBill());
        t1.setDistance(tb.getDistance());
        t1.setStatus(tb.getStatus());
        t1.setDriverId(tb.getDriverId());
        t1.setCustomerId(tb.getCustomerId());
        t1.setFromLocation(tb.getFromLocation());
        t1.setToLocation(tb.getToLocation());
        t1.setFromDateTime(tb.getFromDateTime());
        t1.setToDateTime(tb.getToDateTime());

        return tripBookingRepository.save(t1);
    }
    @Override
    public TripBooking deleteTripBooking(Integer tripBookingId) {

        TripBooking t = tripBookingRepository.findById(tripBookingId).orElseThrow(() -> new TripBookingException("No trip Found"));

        tripBookingRepository.delete(t);

        return t;
    }

}
