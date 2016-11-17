package com.burritomatic.pos.dao.impl;

import com.burritomatic.pos.dao.IngredientDao;
import com.burritomatic.pos.model.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("ingredientDao")
public class IngredientDaoImpl implements IngredientDao{

    @Override
    public Ingredient getIngredient(String ingredientId) {
        return null;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return null;
    }
}
