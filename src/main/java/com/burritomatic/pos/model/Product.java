package com.burritomatic.pos.model;


import java.io.Serializable;
import java.util.List;

public class Product implements Serializable{
    private MenuItem menuItem;
    private List<Ingredient> ingredients;
    private Rule rule;

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }
}
