package com.burritomatic.pos.service;

import static org.junit.Assert.*;

import com.burritomatic.pos.dao.impl.MenuDaoImpl;
import com.burritomatic.pos.model.Menu;
import org.junit.Before;
import org.junit.Test;

public class MenuDaoTest {
	MenuDaoImpl menuDao;
	

	@Before
	public void setup(){
		menuDao = new MenuDaoImpl();
	}
	@Test
	public void test() {
		Menu items = menuDao.retrieveMenu("menu.xml");
		
		assertEquals(3, items.getMenulist().length);
		
		items = menuDao.retrieveMenu("items_.xml");
		assertNull(null, items);
	}

}
