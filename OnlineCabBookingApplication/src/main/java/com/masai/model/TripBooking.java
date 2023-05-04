package com.masai.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Setter
public class TripBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tripBookingId;



    @NotNull(message = "customer id can not be empty")
    @NotBlank(message = "customer id can not be blank")
    @NotEmpty(message = "customer id can not be empty")
//    column should mapped by customer table
    private Integer customerId;


    @NotNull(message = "Driver id can not be empty")
    @NotBlank(message = "Driver id can not be blank")
    @NotEmpty(message = "Driver id can not be empty")
//    column should mapped by driver class
    private Integer driverId;


    @NotNull(message = "Location can not be empty")
    @NotBlank(message = "Location can not be blank")
    @NotEmpty(message = "Location can not be empty")
    private String fromLocation;


    @NotNull(message = "Location can not be empty")
    @NotBlank(message = "Location can not be blank")
    @NotEmpty(message = "Location can not be empty")
    private String toLocation;


    @FutureOrPresent
    private LocalDateTime fromDateTime;

    @Future
    private LocalDateTime toDateTime;

    @NotNull(message = "Status can not be empty")
    @NotBlank(message = "Status can not be blank")
    @NotEmpty(message = "Status can not be empty")
    private Boolean status;


    @NotNull(message = "Distance can not be empty")
    @NotBlank(message = "Distance can not be blank")
    @NotEmpty(message = "Distance can not be empty")
    private float distance;

    @NotNull(message = "Bill can not be empty")
    @NotBlank(message = "Bill can not be blank")
    @NotEmpty(message = "Bill can not be empty")
    private float bill;
}
