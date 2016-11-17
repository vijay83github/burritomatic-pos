package com.burritomatic.pos.dao;

import com.burritomatic.pos.model.Order;

public interface OrderDao {
	public Order createOrder(Order orderInfo);
	
	public Order updateOrder(Order orderInfo);

	public Order retrieveOrder(Long orderId);
	
	
}
