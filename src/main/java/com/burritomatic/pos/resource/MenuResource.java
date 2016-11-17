package com.burritomatic.pos.resource;
 
import com.burritomatic.pos.model.MenuItem;
import com.burritomatic.pos.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pos/menu")
public class MenuResource {
 
    @Autowired
    MenuService menuService;
 
     
    @RequestMapping(value= "/{itemId}", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<MenuItem> getMenuItem(@PathVariable String itemId) {
    	MenuItem item = menuService.getMenuItem(itemId);
        return new ResponseEntity<MenuItem>(item, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<List<MenuItem>> getMenu() {
        List<MenuItem> items = menuService.getMenu();
        return new ResponseEntity<List<MenuItem>>(items, HttpStatus.OK);
    }
 
 
}