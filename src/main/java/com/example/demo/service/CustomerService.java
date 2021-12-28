package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;
	
	public List<Customer> getAll(){
		List<Customer> customer = repo.findAll();
		System.out.println(customer);
		return repo.findAll();
	}
	
	public Customer addCustomer(Customer customer) {
		return repo.save(customer);
	}
	
	public Customer updateCustomer(@PathVariable("custNo") Integer id, @Valid Customer customer) {
		customer.setCustNo(id);
		return repo.save(customer);
	}
	
	public String deleteCustomer(@PathVariable("custNo") Integer id) {
		repo.deleteById(id);
		return "Deleted Successfully";
	}
	
	public Optional<Customer> getById(Integer id){
		return repo.findById(id);
	}
}
