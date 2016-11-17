package com.burritomatic.pos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable{
	private Customer customer;
	
	private List<Product> items;
	
	private float tatal;
	
	private Long id;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Product> getItems() {
		if(items==null){
			items = new ArrayList<Product>();
		}
		return items;
	}
	public void setItems(List<Product> items) {
		this.items = items;
	}
	public float getTatal() {
		return tatal;
	}
	public void setTatal(float tatal) {
		this.tatal = tatal;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
