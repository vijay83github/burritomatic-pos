package com.mo.pos.model;

public enum Tax{
	A(10),B(10),C(0);
	
	private float tax;

	private Tax(float tax) {
		this.tax = tax;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	
}
