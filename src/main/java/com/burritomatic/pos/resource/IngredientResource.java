package com.burritomatic.pos.resource;
 
import com.burritomatic.pos.dao.IngredientDao;
import com.burritomatic.pos.model.Ingredient;
import com.burritomatic.pos.model.IngredientType;
import com.burritomatic.pos.model.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/pos/ingredients")
public class IngredientResource {
 
    @Autowired
    IngredientDao ingredientDao;

    @RequestMapping(value= "/{ingredientId}", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<Ingredient> getIngredient(@PathVariable String ingredientId) {
        Ingredient ingredient = ingredientDao.getIngredient(ingredientId);
        return new ResponseEntity<Ingredient>(ingredient, HttpStatus.OK);
    }

    @RequestMapping(value= "", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<Map<IngredientType,List<Ingredient>>> getAllIngredients() {
        List<Ingredient> ingredients = ingredientDao.getAllIngredients();
        Map<IngredientType,List<Ingredient>> ingredientsByType = seperateIngredientsByType(ingredients);
        return new ResponseEntity<Map<IngredientType,List<Ingredient>>>(ingredientsByType, HttpStatus.OK);
    }

    private Map<IngredientType, List<Ingredient>> seperateIngredientsByType(List<Ingredient> ingredients) {
        Map<IngredientType, List<Ingredient>> ingredientsByType = new HashMap<IngredientType, List<Ingredient>>();
        for (Ingredient ingredient: ingredients){
            List<Ingredient> ingredientList = null;
            if(ingredientsByType.get(ingredient.getType())!=null){
                ingredientList = ingredientsByType.get(ingredient.getType());
            }else{
                ingredientList = new ArrayList<Ingredient>();
            }
            ingredientList.add(ingredient);
            ingredientsByType.put(ingredient.getType(),ingredientList);
        }
        return ingredientsByType;
    }


}