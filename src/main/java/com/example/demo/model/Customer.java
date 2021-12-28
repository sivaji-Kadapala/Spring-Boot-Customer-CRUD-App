package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer custNo;
	
	private String custName;
	private String country;
	public Integer getCustNo() {
		return custNo;
	}
	public void setCustNo(Integer custNo) {
		this.custNo = custNo;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Customer [custNo=" + custNo + ", custName=" + custName + ", country=" + country + "]";
	}
	public Customer() {
	}
	public Customer(Integer custNo, String custName, String country) {
		super();
		this.custNo = custNo;
		this.custName = custName;
		this.country = country;
	}
	public Customer(String custName, String country) {
		super();
		this.custName = custName;
		this.country = country;
	}
	
}
