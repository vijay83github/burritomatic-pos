package com.burritomatic.pos.dao;


import com.burritomatic.pos.model.Menu;

public interface MenuDao {
    public Menu retrieveMenu(String fileName);
}
