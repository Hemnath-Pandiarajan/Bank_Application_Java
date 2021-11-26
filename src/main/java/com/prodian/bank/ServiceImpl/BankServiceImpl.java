package com.prodian.bank.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodian.bank.entity.Account;
import com.prodian.bank.entity.Customer;
import com.prodian.bank.repository.CustomerRepository;
import com.prodian.bank.response.Response;
import com.prodian.bank.service.BankService;

@Service
public class BankServiceImpl implements BankService {

	@Autowired
	private CustomerRepository customerRepository;

	Response response = new Response();

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> customerList = this.customerRepository.findAll();
		return customerList;
	}

	@Override
	public Response createCustomerAccount(Customer customer) {
		Account createAccount = new Account();
		Customer createCustomer = new Customer();
		createCustomer.setFirst_name(customer.getFirst_name());
		createCustomer.setLast_name(customer.getLast_name());
		createCustomer.setMobile_number(customer.getMobile_number());
		createCustomer.setEmail_id(customer.getEmail_id());
		createCustomer.setMpin(customer.getMpin());
		createAccount.setCustomer(createCustomer);
		createCustomer.setAccount(createAccount);
		createCustomer = this.customerRepository.save(createCustomer);
		if (createCustomer != null) {
			response.setStatus("Created Successfully");
		} else {
			response.setStatus("Failed to create");
		}
		return response;
	}

	@Override
	public Customer getCustomerById(long id) {
		Optional<Customer> optionalCustomerData = this.customerRepository.findById(id);
		Customer customerData = optionalCustomerData.get();
		return customerData;
	}

	@Override
	public void deleteCustomerById(long id) {
		this.customerRepository.deleteById(id);
	}
	
	@Override
	public Response updateCustomer(long id, Customer customer) {
		Customer customerData = this.customerRepository.getById(id);
		customerData.setFirst_name(customer.getFirst_name());
		customerData.setLast_name(customer.getLast_name());
		customerData.setMobile_number(customer.getMobile_number());
		customerData.setEmail_id(customer.getEmail_id());
		customerData.setMpin(customer.getMpin());
		customerData=this.customerRepository.save(customerData);
		if(customerData!=null) {
			response.setStatus("Customer updated successfully");
		}else {
			response.setStatus("Something went wrong,Cant able to edit");
		}
		return response;
	}
}
