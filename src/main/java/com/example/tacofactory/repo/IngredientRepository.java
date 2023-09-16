package com.example.tacofactory.repo;

import com.example.tacofactory.model.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient,String> {
    Iterable<Ingredient> getByType(Ingredient.Type t);


}
