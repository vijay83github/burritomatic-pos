package com.mo.pos.resource;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mo.pos.model.Item;
import com.mo.pos.service.ItemService;
@RestController
@RequestMapping(value = "/pos/items")
public class ItemResource {
 
    @Autowired
    ItemService itemService;  
 
     
    @RequestMapping(value= "/{itemId}", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<Item> getItem(@PathVariable String itemId) {
    	Item item = itemService.getItem(itemId);
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }
 
 
 
}