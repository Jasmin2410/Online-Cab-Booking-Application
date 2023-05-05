package com.masai.exception.tripBooking;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorDetails {
    private LocalDateTime timeStamp;
    private String message;
    private String details;
}
