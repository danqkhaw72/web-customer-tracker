package com.kamu.springdemo.dao;

import java.util.List;

import com.kamu.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

}
