package com.masai.service;

import com.masai.exception.tripBooking.TripBookingException;
import com.masai.model.TripBooking;

public interface TripBookingService {
    public TripBooking insertTripBooking(TripBooking tb) throws TripBookingException;
    public TripBooking updateTripBooking(TripBooking tb) throws TripBookingException;
    public TripBooking deleteTripBooking(Integer tripBookingId) throws TripBookingException;
}
