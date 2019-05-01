package com.springCurd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springCurd.dao.CurdDao;
import com.springCurd.entity.Customer;
import com.springCurd.entity.User;

@Service
public class CurdServiceImpl implements CurdService {

	@Autowired
	private CurdDao dao;

	@Override
	public User authenticateUser(User user) {

		return dao.authenticateUser(user);
	}

	@Override
	public List<Customer> getCustomers() {
		return dao.getCustomers();
	}

	@Override
	public String saveCustomer(Customer customer) {
		return dao.saveCustomer(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		return dao.getCustomer(id);
	}

	@Override
	public String updateCustomer(Customer customer) {
		return dao.updateCustomer(customer);
	}

	@Override
	public String deleteCustomer(int theId) {
		return dao.deleteCustomer(theId);
	}

}
