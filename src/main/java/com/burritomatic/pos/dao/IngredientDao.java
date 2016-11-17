package com.burritomatic.pos.dao;


import com.burritomatic.pos.model.Ingredient;

import java.util.List;

public interface IngredientDao {
    Ingredient getIngredient(String ingredientId);

    List<Ingredient> getAllIngredients();
}
