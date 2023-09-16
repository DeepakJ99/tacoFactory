package com.example.tacofactory;

import com.example.tacofactory.model.Ingredient;
import com.example.tacofactory.repo.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@ComponentScan({"com.example.tacofactory.service",
        "com.example.tacofactory.repo",
        "com.example.tacofactory.security",
"com.example.tacofactory.config"})
public class TacofactoryApplication implements CommandLineRunner {

    @Autowired
    public IngredientRepository repo;
    public static void main(String[] args) {
        SpringApplication.run(TacofactoryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception{

        List<Ingredient> all = Arrays.asList(
                new Ingredient("FLTO","Flour Tortilla", Ingredient.Type.WRAP),
                new Ingredient("COTO","Corn Tortilla", Ingredient.Type.WRAP),
                new Ingredient("GRBF","Ground Beef", Ingredient.Type.PROTEIN),
                new Ingredient("CARN","Cornitoes", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO","Diced Tomato", Ingredient.Type.VEGGIES),
                new Ingredient("LETC","Lettuce", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
                new Ingredient("JACK","Monterrey Cheese", Ingredient.Type.CHEESE),
                new Ingredient("SLSA","Salsa", Ingredient.Type.SAUCE),
                new Ingredient("MRNA","Marinara", Ingredient.Type.SAUCE)
        );
        repo.saveAll(all);

    }
}
