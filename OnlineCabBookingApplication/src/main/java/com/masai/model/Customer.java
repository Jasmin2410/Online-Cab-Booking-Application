package com.masai.model;

import jakarta.persistence.Entity;

@Entity
public class Customer extends AbstractUser {
@Override
	public String toString() {
		return "Customer [customerId=" + customerId + "]";
	}

public Customer(Integer customerId) {
		super();
		this.customerId = customerId;
	}

public Customer(String userName, String password, String address, String mobileNumber, String email) {
	super(userName, password, address, mobileNumber, email);
}

public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

private Integer customerId;



}
