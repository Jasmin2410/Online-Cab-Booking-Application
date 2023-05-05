package com.masai.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Driver extends AbstractUser{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer driverId;
	
	
	@Size(min = 6, max=6, message = "Licence Number should be 6 Characters")
	@Column(unique = true)
	private String licenceNo;
	
	@Max(value=5,message = "Rating must be <= 5")
	@Min(value=0,message = "Rating must be more than 0")
	private Float rating;
	
	@Embedded
	private Cab cab;
	
	@JsonIgnore
	@OneToMany(mappedBy = "driverId")
	private Set<TripBooking> tripBookings = new HashSet<>();

	
	
	public Driver(Integer driverId,
			@Size(min = 6, max = 6, message = "Licence Number should be 6 Characters") String licenceNo,
			@Max(value = 5, message = "Rating must be <= 5") @Min(value = 0, message = "Rating must be more than 0") Float rating,
			Cab cab, Set<TripBooking> tripBookings) {
		super();
		this.driverId = driverId;
		this.licenceNo = licenceNo;
		this.rating = rating;
		this.cab = cab;
		this.tripBookings = tripBookings;
	}


	public Driver(Integer driverId,
			@Size(min = 6, max = 6, message = "Licence Number should be 6 Characters") String licenceNo,
			@Max(value = 5, message = "Rating must be <= 5") @Min(value = 0, message = "Rating must be more than 0") Float rating,
			Cab cab) {
		super();
		this.driverId = driverId;
		this.licenceNo = licenceNo;
		this.rating = rating;
		this.cab = cab;
	}


	public Driver(String userName, String password, String address, String mobileNumber, String email,
			@Size(min = 6, max = 6, message = "Licence Number should be 6 Characters") String licenceNo,
			@Max(value = 5, message = "Rating must be <= 5") @Min(value = 0, message = "Rating must be more than 0") Float rating,
			Cab cab) {
		super(userName, password, address, mobileNumber, email);
		this.licenceNo = licenceNo;
		this.rating = rating;
		this.cab = cab;
	}

	public Driver() {
		super();
	}


	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", licenceNo=" + licenceNo + ", rating=" + rating + ", cab=" + cab
				+ ", tripBookings=" + tripBookings + "]";
	}



}
