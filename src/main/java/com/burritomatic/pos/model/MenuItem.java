package com.burritomatic.pos.model;

import java.io.Serializable;

public class MenuItem implements Serializable{
	private String name;
	
	private float price;
	
	private int id;

	private Rule rule;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
