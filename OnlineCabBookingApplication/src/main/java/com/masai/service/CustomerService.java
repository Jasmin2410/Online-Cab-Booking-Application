package com.masai.service;

import java.util.List;

import com.masai.model.Customer;

public interface CustomerService {
public Customer insertCustomer(Customer customer);
public Customer updateCustomer(Customer customer);
public Customer deleteCustomer(Integer id);
public List<Customer> veiwCustomers();
public Customer viewCustomer(int customerId);
public Customer validateCustomer(String username,String password);
}
