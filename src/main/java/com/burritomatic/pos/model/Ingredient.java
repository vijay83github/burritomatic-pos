package com.burritomatic.pos.model;


public class Ingredient {
    private String name;
    private IngredientType type;
    private Rule rule;

    public Ingredient(String name, IngredientType type){
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IngredientType getType() {
        return type;
    }

    public void setType(IngredientType type) {
        this.type = type;
    }
}
