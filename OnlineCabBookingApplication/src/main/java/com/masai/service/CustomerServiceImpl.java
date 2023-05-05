package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.masai.exception.CustomerException;
import com.masai.model.Customer;
import com.masai.repository.CustomerRepository;

public class CustomerServiceImpl implements CustomerService{
	
	
    @Autowired
	private CustomerRepository cr;
    
	@Override
	public Customer insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		Customer existingCustomer=cr.findById(customer.getCustomerId());
		
		if(existingCustomer==null) {
			
			Customer cust=cr.save(customer);
			return cust;
		}else {
			throw new CustomerException();
		}
		
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Customer deleteCustomer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> veiwCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer viewCustomer(int customerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer validateCustomer(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
