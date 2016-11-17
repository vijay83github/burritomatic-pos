package com.burritomatic.pos.service;

import com.burritomatic.pos.dao.impl.MenuDaoImpl;
import com.burritomatic.pos.model.Menu;
import com.burritomatic.pos.model.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.burritomatic.pos.utils.ApplicationConstants;

import java.util.Arrays;
import java.util.List;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	MenuDaoImpl menuDao;
	
	@Override
	public MenuItem getMenuItem(String itemId) {
		Menu items =  menuDao.retrieveMenu(ApplicationConstants.MENU_XML);
		MenuItem[] itemList = items.getMenulist();
		for (MenuItem item : itemList) {
			if(itemId.equals(String.valueOf(item.getId()))){
				return item;
			}
		}
		return null;
	}

	@Override
	public List<MenuItem> getMenu() {
		Menu items =  menuDao.retrieveMenu(ApplicationConstants.MENU_XML);
		return Arrays.asList(items.getMenulist());
	}

}
