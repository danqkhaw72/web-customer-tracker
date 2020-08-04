package com.kamu.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kamu.springdemo.dao.CustomerDAO;
import com.kamu.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// need to inject the customer DAO
	@Autowired
	private CustomerDAO customerDAO;
	
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		
		// get customers from the dao
		List<Customer> theCustomers = customerDAO.getCustomer();
		
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customer";
	}

}
