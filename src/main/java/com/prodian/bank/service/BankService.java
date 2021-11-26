package com.prodian.bank.service;

import java.util.List;  

import org.springframework.stereotype.Service;

import com.prodian.bank.entity.Customer;
import com.prodian.bank.response.Response;

@Service
public interface BankService {
	
	public List<Customer> getAllCustomer();
	public Response createCustomerAccount(Customer customer);
	public Customer getCustomerById(long id);
	public void deleteCustomerById(long id);
	public Response updateCustomer(long id,Customer customer);
}
