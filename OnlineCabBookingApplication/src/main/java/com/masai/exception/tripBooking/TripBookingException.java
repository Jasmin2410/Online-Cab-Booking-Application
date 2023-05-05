package com.masai.exception.tripBooking;

import com.masai.service.TripBookingService;

public class TripBookingException extends RuntimeException{
    public TripBookingException(String msg){
        super(msg);
    }
}
