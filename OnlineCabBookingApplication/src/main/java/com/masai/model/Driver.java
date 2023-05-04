package com.masai.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Driver extends AbstractUser{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer driverId;
	
	@NotEmpty(message = "Licence Number Can Not be Empty")
	@NotNull(message = "Licence Number Can not be Null")
	@NotBlank(message = "Licence Number can Not be Blank")
	@Size(min = 6, max=6, message = "Licence Number should be 6 Characters")
	private String licenceNo;
	
	
	private Float rating;
	
	@Embedded
	private Cab cab;
	
//	@OneToMany(mappedBy = "")
//	private Set<TripBooking> tripBookings = new HashSet<>();



}
