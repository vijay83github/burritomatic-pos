package com.mo.pos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable{
	private String customer;
	
	private List<Item> items;
	
	private float tatal;
	
	private Long id;
	
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public List<Item> getItems() {
		if(items==null){
			items = new ArrayList<Item>();
		}
		return items;
	}
	public void setItems(List<Item> items) {
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
