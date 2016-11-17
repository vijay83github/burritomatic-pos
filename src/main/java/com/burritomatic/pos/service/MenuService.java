package com.burritomatic.pos.service;

import com.burritomatic.pos.model.MenuItem;

import java.util.List;

public interface MenuService {
	MenuItem getMenuItem(String itemId);
	List<MenuItem> getMenu();

}
