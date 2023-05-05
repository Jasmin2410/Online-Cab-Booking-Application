package com.masai.exception.tripBooking;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> methodArgumentNotValidException(MethodArgumentNotValidException me, WebRequest req){

        ErrorDetails ed = new ErrorDetails();
        ed.setTimeStamp(LocalDateTime.now());
        ed.setMessage(me.getBindingResult().getFieldError().getDefaultMessage());
        ed.setDetails(req.getDescription(false));

        return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(TripBookingException.class)
    public ResponseEntity<ErrorDetails> tripBookingException(TripBookingException me, WebRequest req){

        ErrorDetails ed = new ErrorDetails();
        ed.setTimeStamp(LocalDateTime.now());
        ed.setMessage(me.getMessage());
        ed.setDetails(req.getDescription(false));

        return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDetails> noHandlerFoundException(NoHandlerFoundException me, WebRequest req){

        ErrorDetails ed = new ErrorDetails();
        ed.setTimeStamp(LocalDateTime.now());
        ed.setMessage(me.getMessage());
        ed.setDetails(req.getDescription(false));

        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

}
