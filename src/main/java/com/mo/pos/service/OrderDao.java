package com.mo.pos.service;

import com.mo.pos.model.Order;

public interface OrderDao {
	public Order createOrder(Order orderInfo);
	
	public Order updateOrder(Order orderInfo);

	public Order retrieveOrder(Long orderId);
	
	
}
