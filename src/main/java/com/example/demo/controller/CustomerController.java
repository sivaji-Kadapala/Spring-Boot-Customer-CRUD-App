package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.http.ResponseEntity.status;

import java.util.List;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/cust")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	//http://localhost:8080/cust/checking
	@GetMapping("/checking")
	public String hello() {
		return "Hello Virtusa";
	}
	//http://localhost:8080/cust/customer/1
	@GetMapping("/customer/{id}")
	public ResponseEntity<?> getCustById(@PathVariable Integer id) {
		return status(200).body(service.getById(id));
	}
	//http://localhost:8080/cust/findAll
	@GetMapping("/findAll")
	public List<Customer> getAll(){
		return service.getAll();
	}
	//http://localhost:8080/cust/add
	@PostMapping("/add")
	public ResponseEntity<?> addUser(@RequestBody Customer customer){
		return status(200).body(service.addCustomer(customer));
	}
	//http://localhost:8080/cust/update/1
	@PutMapping("/update/{custNo}")
	public ResponseEntity<?> updateUser(@PathVariable("custNo") Integer id, @RequestBody Customer customer){
		return status(200).body(service.updateCustomer(id, customer));
	}
	//http://localhost:8080/cust/delete/1
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") Integer id, Model model){
		return status(200).body(service.deleteCustomer(id));
	}
	
}
