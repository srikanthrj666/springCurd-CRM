package com.springCurd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.springCurd.entity.Customer;
import com.springCurd.entity.User;

@Repository
public class CurdDaoImpl implements CurdDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User authenticateUser(User user) {

		String sql = "SELECT USERNAME, PASSWORD FROM USERS WHERE USERNAME = '" + user.getUserName()
				+ "' AND PASSWORD = '" + user.getPassword() + "'";

		User user2 = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User tempUser = new User();
				tempUser.setUserName(rs.getString("username"));
				tempUser.setPassword(rs.getString("password"));
				return tempUser;
			}
		});

		return user2;
	}

	@Override
	public List<Customer> getCustomers() {

		String sql = "SELECT ID, FIRST_NAME, LAST_NAME,EMAIL FROM CUSTOMER";

		List<Customer> customers = jdbcTemplate.query(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer();

				customer.setId(rs.getInt("id"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("last_name"));
				customer.setEmail(rs.getString("email"));

				return customer;
			}
		});

		return customers;
	}

	@Override
	public String saveCustomer(Customer customer) {
		String sql = "INSERT INTO CUSTOMER (FIRST_NAME, LAST_NAME, EMAIL) VALUES (?,?,?)";

		int i = jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(), customer.getEmail());
		if (i != 0) {
			return "SUCCESS";
		}
		return "FAIl";
	}

	@Override
	public Customer getCustomer(int id) {

		String sql = "SELECT ID,FIRST_NAME,LAST_NAME,EMAIL FROM CUSTOMER WHERE ID = " + id;

		Customer customer = jdbcTemplate.queryForObject(sql, new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer();

				customer.setId(rs.getInt("id"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setLastName(rs.getString("last_name"));
				customer.setEmail(rs.getString("email"));

				return customer;
			}
		});

		return customer;
	}

	@Override
	public String updateCustomer(Customer customer) {

		String sql = "UPDATE CUSTOMER SET FIRST_NAME = ?,LAST_NAME=?,EMAIL=? WHERE  ID=?";

		int i = jdbcTemplate.update(sql, customer.getFirstName(), customer.getLastName(), customer.getEmail(),
				customer.getId());

		if (i != 0) {
			return "SUCCESS";
		}

		return "FAIL";
	}

	@Override
	public String deleteCustomer(int theId) {

		String sql = "DELETE FROM CUSTOMER WHERE  ID=?";
		int i = jdbcTemplate.update(sql, theId);
		if (i != 0) {
			return "SUCCESS";
		}

		return "FAIL";
	}

}
