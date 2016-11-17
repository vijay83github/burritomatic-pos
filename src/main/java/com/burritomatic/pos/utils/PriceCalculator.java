package com.burritomatic.pos.utils;

import java.util.List;

import com.burritomatic.pos.model.Order;
import com.burritomatic.pos.model.Product;

public class PriceCalculator {

	public static void calculateTotal(Order orderInfo) {
		float total = 0f;
		List<Product> products = orderInfo.getItems();
		for (Product product : products) {
			total = total + product.getMenuItem().getPrice() ;
		}
		orderInfo.setTatal(total);
		applyBusinessRules(orderInfo);
	}

	private static void applyBusinessRules(Order orderInfo) {
		RulesEngine rulesEngine = new RulesEngine();
		rulesEngine.validateRules(orderInfo);
	}

}
