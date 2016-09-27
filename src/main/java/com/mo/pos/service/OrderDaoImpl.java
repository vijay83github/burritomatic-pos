package com.mo.pos.service;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mo.pos.model.Order;

@Repository("orderDao")
public class OrderDaoImpl implements OrderDao{
	private static final String FILE_LOCATION = "src/main/resources/order.ser";

	private static Long counter = new Long(0L);
	
	private static File file;
	
	private static List<Order> orders = new ArrayList<Order>();
	
	@Autowired
	ItemReader  herdReader;
	

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
		orders.set(index, orderInfo);
		writeList(orders);
		return orderInfo;
	}

	@Override
	public Order retrieveOrder(Long orderId) {
		// TODO Auto-generated method stub
		return findById(orderId);
	}
	

	
	
	
	static{
		orders = readList();
	}

	public List<Order> findAllOrders() {
		if(orders!=null && orders.isEmpty()){
			orders = readList();
		}
		return orders;
	}
	
	public Order findById(long id) {
		for(Order order : orders){
			if(order.getId() == id){
				return order;
			}
		}
		return null;
	}
	
	
	public void deleteOrderById(long id) {
		for (Iterator<Order> iterator = orders.iterator(); iterator.hasNext(); ) {
		    Order user = iterator.next();
		    if (user.getId() == id) {
		        iterator.remove();
		    }
		}
		writeList(orders);
	}

	public boolean isOrderExist(Long orderId) {
		return findById(orderId)!=null;
	}
	
	public void deleteAllOrders(){
		orders.clear();
		writeList(orders);
	}

	private static List<Order> readList(){
		System.out.println("Reading List from File : Start");
		ObjectInputStream objectinputstream = null;
		 List<Order> recordList = new ArrayList<Order>();;
		try {
			FileInputStream streamIn = new FileInputStream(FILE_LOCATION);
		    objectinputstream = new ObjectInputStream(streamIn);
		    List<Order> readObject = (List<Order>) objectinputstream.readObject();
			recordList = readObject;
		} catch (EOFException e) {
			recordList = new ArrayList<Order>();
		}catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    if(objectinputstream != null){
		        try {
					objectinputstream .close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    } 
		}
		System.out.println("Reading List from File : End : users ="+orders.toString());
		return recordList;
	}
	
	private static void writeList(List<Order> usersList){
		System.out.println("Writing List to File : Start");
		ObjectOutputStream oos = null;
		FileOutputStream fout = null;
		try{
		     fout = new FileOutputStream(FILE_LOCATION, false);
		     oos = new ObjectOutputStream(fout);
		    oos.writeObject(usersList);
		} catch (Exception ex) {
		    ex.printStackTrace();
		} finally {
		    if(oos  != null){
		        try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    } 
		}
		System.out.println("Writing List to File : End : users ="+orders.toString());
	}



}
