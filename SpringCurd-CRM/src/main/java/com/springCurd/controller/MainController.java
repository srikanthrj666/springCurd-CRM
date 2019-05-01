package com.springCurd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springCurd.entity.Customer;
import com.springCurd.entity.User;
import com.springCurd.service.CurdService;

@Controller
public class MainController {

	@Autowired
	private CurdService service;

	@RequestMapping("/")
	public String showLoginPage(@ModelAttribute("user") User user) {

		System.out.println("******** MainController::: showLoginPage Method ***********");

		return "loginPage";

	}

	@RequestMapping("/loginProcess")
	public String loginProcess(@ModelAttribute("user") User user, HttpServletRequest request, Model model) {

		System.out.println("******** MainController::: loginProcess Method ***********");
		System.out.println(user);

		User userPro = service.authenticateUser(user);
		if (userPro != null) {
			System.out.println("UserPro :::" + userPro);
			HttpSession session = request.getSession();
			System.out.println("Http Serssion Id :::" + session.getId());
			session.setAttribute("userPro", userPro);

			List<Customer> customers = service.getCustomers();
			System.out.println(customers);
			model.addAttribute("customers", customers);
			return "customers";
		}

		return "loginPage";

	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(@ModelAttribute("customer") Customer customer, HttpServletRequest request) {

		System.out.println("******** MainController::: showFormForAdd Method ***********");

		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("userPro"));
		if (session.getAttribute("userPro") != null) {

			System.out.println("Http Serssion Id :::" + session.getId());

			return "addCustomer";
		}
		return "login";

	}

	@RequestMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer, HttpServletRequest request, Model model) {

		System.out.println("******** MainController::: saveCustomer Method ***********");

		System.out.println(customer);

		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("userPro"));
		if (session.getAttribute("userPro") != null) {

			System.out.println("Http Serssion Id :::" + session.getId());

			String status = service.saveCustomer(customer);
			if (status == "SUCCESS") {

				List<Customer> customers = service.getCustomers();
				System.out.println(customers);
				model.addAttribute("customers", customers);
				model.addAttribute("status", "customer added successfully ");
				return "customers";

			}

		}
		model.addAttribute("status", "faill to add customer ");
		return "addCustomer";

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model model, HttpServletRequest request) {

		System.out.println("******** MainController::: showFormForUpdate Method ***********");

		HttpSession session = request.getSession();

		if (session.getAttribute("userPro") != null) {

			System.out.println("Http Serssion Id :::" + session.getId());

			Customer theCustomer = service.getCustomer(theId);
			model.addAttribute("customer", theCustomer);
			return "updateCustomer";

		}

		return "loginPage";
	}

	@RequestMapping("/updateProcess")
	public String updateProcess(@ModelAttribute("customer") Customer customer, Model model,
			HttpServletRequest request) {

		System.out.println("******** MainController::: updateProcess Method ***********");
		System.out.println(customer);

		HttpSession session = request.getSession();

		if (session.getAttribute("userPro") != null) {

			System.out.println("Http Serssion Id :::" + session.getId());

			String status = service.updateCustomer(customer);

			if (status == "SUCCESS") {
				model.addAttribute("status", "customer updated successfully ");

			} else {

				model.addAttribute("status", "faill to update customer  ");

			}

		}

		List<Customer> customers = service.getCustomers();
		System.out.println(customers);
		model.addAttribute("customers", customers);
		model.addAttribute("status", "customer added successfully ");

		return "customers";

	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId, Model model, HttpServletRequest request) {

		System.out.println("******** MainController::: deleteCustomer Method ***********");

		HttpSession session = request.getSession();

		if (session.getAttribute("userPro") != null) {

			System.out.println("Http Serssion Id :::" + session.getId());

			String status = service.deleteCustomer(theId);
			model.addAttribute("status", "customer deleted successfully ");

		}

		List<Customer> customers = service.getCustomers();
		System.out.println(customers);
		model.addAttribute("customers", customers);

		return "customers";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, @ModelAttribute("user") User user) {

		System.out.println("******** MainController::: logout Method ***********");

		session.invalidate();

		return "loginPage";
	}

}
