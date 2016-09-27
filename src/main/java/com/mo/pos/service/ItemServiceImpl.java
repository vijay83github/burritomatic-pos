package com.mo.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mo.pos.model.Item;
import com.mo.pos.model.Items;
import com.mo.pos.utils.ApplicationConstants;
@Service("itemService")
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemReader itemReader;
	
	@Override
	public Item getItem(String itemId) {
		Items items =  itemReader.readList(ApplicationConstants.ITEMS_XML);
		Item[] itemList = items.getItems();
		for (Item item : itemList) {
			if(itemId.equals(String.valueOf(item.getId()))){
				return item;
			}
		}
		return null;
	}

}
