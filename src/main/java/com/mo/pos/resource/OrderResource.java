package com.mo.pos.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mo.pos.model.Item;
import com.mo.pos.model.Order;
import com.mo.pos.service.OrderDao;
import com.mo.pos.utils.PriceCalculator;

@RestController
@RequestMapping(value = "/pos/order")

public class OrderResource {
	@Autowired
	OrderDao orderDao;

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Order> createOrder(@RequestBody String customer) {
		Order orderInfo = new Order();
		orderInfo.setCustomer(customer);
		orderDao.createOrder(orderInfo);
		return new ResponseEntity<Order>(orderInfo, HttpStatus.OK);
	}

	@RequestMapping(value = "/{orderId}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public ResponseEntity<Order> updateOrder(@PathVariable String orderId, @RequestBody Item item) {
		Order orderInfo = orderDao.retrieveOrder(Long.valueOf(orderId));
		orderInfo.getItems().add(item);
		orderInfo.setTatal(PriceCalculator.calculateTotal(orderInfo));
		return new ResponseEntity<Order>(orderInfo, HttpStatus.OK);
	}

	@RequestMapping(value = "/{orderId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Order> checkout(@PathVariable String orderId) {
		Order orderInfo = orderDao.retrieveOrder(Long.valueOf(orderId));
		if (orderInfo == null) {
			return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);// You many decide to return HttpStatus.NOT_FOUND
																	
		}
		orderInfo.setTatal(PriceCalculator.calculateTotal(orderInfo));
		return new ResponseEntity<Order>(orderInfo, HttpStatus.OK);
	}

}