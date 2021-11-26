package com.prodian.bank.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prodian.bank.entity.Customer;
import com.prodian.bank.response.Response;
import com.prodian.bank.service.BankService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/customer")
public class BankController {

	@Autowired
	private BankService bankService;

	public BankController(BankService bankService) {
		super();
		this.bankService = bankService;
	}

	public BankController() {
		super();
	}

	@GetMapping("/allCustomers")
	public List<Customer> getAllCustomer() {
		return this.bankService.getAllCustomer();
	}

	@PostMapping("/createCustomerAccount")
	public Response createCustomer(@RequestBody Customer customer) {
		return this.bankService.createCustomerAccount(customer);
	}
	
	@GetMapping("/getCustomer/{id}")
	public Customer getCustomerById(@PathVariable long id) {
		return this.bankService.getCustomerById(id);
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public Response deleteCustomerById(@PathVariable long id) {
		this.bankService.deleteCustomerById(id);
		Response deleteStatus = new Response();
		deleteStatus.setStatus("Customer Removed Successfully");
		return deleteStatus;
	}
	
	@PutMapping("/editCustomer/{id}")
	public Response updateCustomer(@PathVariable(value="id") long id,@RequestBody Customer customer) {
		return this.bankService.updateCustomer(id, customer);
	}
}
