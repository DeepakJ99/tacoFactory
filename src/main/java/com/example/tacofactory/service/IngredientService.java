package com.example.tacofactory.service;


import com.example.tacofactory.model.Ingredient;
import com.example.tacofactory.repo.IngredientRepository;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;


@Data
@Builder
@Service
public class IngredientService {

    private final IngredientRepository repo;

    public Iterable<Ingredient> getByType(Ingredient.Type t){
        return repo.getByType(t);
    }
    public boolean save(Ingredient i){
        if(repo.existsById(i.getId())){
            return false;
        }

        repo.save(i);
        return true;
    }

//    public Ingredient.Type[] getAllTypes(){
//        return repo.getAllTypes();
//    }

}
