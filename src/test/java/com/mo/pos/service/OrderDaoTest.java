package com.mo.pos.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mo.pos.model.Category;
import com.mo.pos.model.Item;
import com.mo.pos.model.Order;

public class OrderDaoTest {
	
	OrderDao orderDao;
	
	@Before
	public void setup(){
		orderDao = new OrderDaoImpl();
	}

	@Test
	public void testCreateOrder() {
		Order orderInfo = new Order();
		orderInfo.setCustomer("abcd");
		orderInfo = orderDao.createOrder(orderInfo);
		assertNotNull(orderInfo.getId());
	}

	@Test
	public void testUpdateOrder() {
		Order orderInfo = new Order();
		orderInfo.setCustomer("abcd");
		Item item = new Item();
		item.setCategory(Category.A);
		item.setPrice(25.4f);
		item.setName("Mouse");
		item.setId(555);
		orderInfo.getItems().add(item);
		
		orderInfo = orderDao.updateOrder(orderInfo);
		assertNotNull(orderInfo.getId());
	}

	@Test
	public void testRetrieveOrder() {
		Order orderInfo = new Order();
		orderInfo.setCustomer("abcd");
		Item item = new Item();
		item.setCategory(Category.A);
		item.setPrice(25.4f);
		item.setName("Mouse");
		item.setId(555);
		orderInfo.getItems().add(item);
		
		orderInfo = orderDao.updateOrder(orderInfo);
		assertNotNull(orderInfo.getId());
		assertNotNull(orderDao.retrieveOrder(orderInfo.getId()));
	}

	

}
