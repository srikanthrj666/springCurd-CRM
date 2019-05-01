package com.springCurd.dao;

import java.util.List;

import com.springCurd.entity.Customer;
import com.springCurd.entity.User;

public interface CurdDao {

	User authenticateUser(User user);

	List<Customer> getCustomers();

	String saveCustomer(Customer customer);

	Customer getCustomer(int id);

	String updateCustomer(Customer customer);

	String deleteCustomer(int theId);

}
