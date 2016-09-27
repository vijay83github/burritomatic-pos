package com.mo.pos.service;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mo.pos.model.Order;

@Repository("orderDao")
public class OrderDaoImpl implements OrderDao {
	private static final String FILE_LOCATION = "src/main/resources/order.ser";

	private static Long counter = new Long(0L);

	private static List<Order> orders = new ArrayList<Order>();

	@Autowired
	ItemReader herdReader;

	@Override
	public Order createOrder(Order orderInfo) {
		counter = Long.valueOf(System.currentTimeMillis());
		orderInfo.setId(counter);
		orders.add(orderInfo);
		writeList(orders);
		return orderInfo;
	}

	@Override
	public Order updateOrder(Order orderInfo) {
		int index = orders.indexOf(orderInfo);
		if (index != -1) {
			orders.set(index, orderInfo);
		} else {
			counter = Long.valueOf(System.currentTimeMillis());
			orderInfo.setId(counter);
			orders.add(orderInfo);
		}
		writeList(orders);
		return orderInfo;
	}

	@Override
	public Order retrieveOrder(Long orderId) {
		return findById(orderId);
	}

	static {
		orders = readList();
	}

	public List<Order> findAllOrders() {
		if (orders != null && orders.isEmpty()) {
			orders = readList();
		}
		return orders;
	}

	private Order findById(long id) {
		for (Order order : orders) {
			if (order.getId() == id) {
				return order;
			}
		}
		return null;
	}

	

	@SuppressWarnings("unchecked")
	private static List<Order> readList() {
		System.out.println("Reading List from File : Start");
		ObjectInputStream objectinputstream = null;
		List<Order> recordList = new ArrayList<Order>();
		;
		try {
			FileInputStream streamIn = new FileInputStream(FILE_LOCATION);
			objectinputstream = new ObjectInputStream(streamIn);
			List<Order> readObject = (List<Order>) objectinputstream.readObject();
			recordList = readObject;
		} catch (EOFException e) {
			recordList = new ArrayList<Order>();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (objectinputstream != null) {
				try {
					objectinputstream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Reading List from File : End : users =" + orders.toString());
		return recordList;
	}

	private static void writeList(List<Order> usersList) {
		System.out.println("Writing List to File : Start");
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(FILE_LOCATION, false);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(usersList);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Writing List to File : End : users =" + orders.toString());
	}

}
