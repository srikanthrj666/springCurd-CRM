package com.springCurd.service;

import java.util.List;

import com.springCurd.entity.Customer;
import com.springCurd.entity.User;

public interface CurdService {

	User authenticateUser(User user);

	List<Customer> getCustomers();

	String saveCustomer(Customer customer);

	Customer getCustomer(int theId);

	String updateCustomer(Customer customer);

	String deleteCustomer(int theId);

}
