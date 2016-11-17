package com.burritomatic.pos.service;

import static org.junit.Assert.*;

import com.burritomatic.pos.dao.OrderDao;
import com.burritomatic.pos.dao.impl.OrderDaoImpl;
import com.burritomatic.pos.model.*;
import org.junit.Before;
import org.junit.Test;

public class OrderDaoTest {
	
	OrderDao orderDao;
	
	@Before
	public void setup(){
		orderDao = new OrderDaoImpl();
	}

	@Test
	public void testCreateOrder() {
		Order orderInfo = new Order();
		Customer customer = new Customer();
		customer.setName("abcd");
		orderInfo = orderDao.createOrder(orderInfo);
		assertNotNull(orderInfo.getId());
	}

	@Test
	public void testUpdateOrder() {
		Order orderInfo = new Order();
		Customer customer = new Customer();
		customer.setName("abcd");
		orderInfo.setCustomer(customer);
		MenuItem item = new MenuItem();
		item.setPrice(25.4f);
		item.setName("Mouse");
		item.setId(555);
		Product product = new Product();
		product.setMenuItem(item);
		orderInfo.getItems().add(product);
		
		orderInfo = orderDao.updateOrder(orderInfo);
		assertNotNull(orderInfo.getId());
	}

	@Test
	public void testRetrieveOrder() {
		Order orderInfo = new Order();
		Customer customer = new Customer();
		customer.setName("abcd");
		orderInfo.setCustomer(customer);
		MenuItem item = new MenuItem();
		item.setPrice(25.4f);
		item.setName("Mouse");
		item.setId(555);
		Product product = new Product();
		product.setMenuItem(item);
		orderInfo.getItems().add(product);


		orderInfo = orderDao.updateOrder(orderInfo);
		assertNotNull(orderInfo.getId());
		assertNotNull(orderDao.retrieveOrder(orderInfo.getId()));
	}

	

}
