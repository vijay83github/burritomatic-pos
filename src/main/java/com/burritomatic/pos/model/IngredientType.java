package com.burritomatic.pos.model;

public enum IngredientType {
    BASE("Base"),MEAT("Meat"),SALSA("Salsa"), TOPPINGS("Toppings");
    private final String type;

    IngredientType(String type){
        this.type = type;
    }
    public static IngredientType getValueOf(String type){
        for (IngredientType  ingredientType : values()) {
            if(ingredientType.getType().equals(type)){
                return ingredientType;
            }
        }
        return null;
    }

    public String getType() {
        return type;
    }
}
