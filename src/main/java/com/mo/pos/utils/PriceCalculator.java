package com.mo.pos.utils;

import java.util.List;

import com.mo.pos.model.Item;
import com.mo.pos.model.Order;
import com.mo.pos.model.Tax;

public class PriceCalculator {

	public static float calculateTotal(Order orderInfo) {
		float total = 0f;
		List<Item> itemList = orderInfo.getItems();
		for (Item item : itemList) {
			total = total + item.getPrice() + calculateTax(item);
		}
		return total;
	}

	private static float calculateTax(Item item) {
		return item.getPrice()*(Tax.valueOf(item.getCategory().toString()).getTax()/100);
	}

}
