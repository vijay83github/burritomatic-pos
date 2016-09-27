package com.mo.frontdesk.service;

import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.mo.pos.model.Items;
import com.mo.pos.service.ItemReader;

import static org.junit.Assert.assertEquals;
public class ItemReaderTest {
	ItemReader itemReader;
	

	@Before
	public void setup(){
		itemReader = new ItemReader();
	}
	@Test
	public void test() {
		Items items = itemReader.readList("items.xml");
		
		assertEquals(3, items.getItems().length);
		
		items = itemReader.readList("items_.xml");
		assertNull(null, items);
	}

}
