package com.project.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Billing {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(length =  30)
    private String customerName;
	@Column(length = 80)
    private String billingAddress;
	@Column
    private double totalCost;
	@Column(length = 20)
    private String paymentMethod;
    @OneToMany //one bill can have many products
    private List<Product>product;
    
    public Billing(Long id, String customerName, String billingAddress, double totalCost, String paymentMethod) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.billingAddress = billingAddress;
		this.totalCost = totalCost;
		this.paymentMethod = paymentMethod;
	}
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public Billing() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

