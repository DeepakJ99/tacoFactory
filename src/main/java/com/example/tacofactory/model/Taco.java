package com.example.tacofactory.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotNull
    @Size(min=5, message = "Name must be at-least 5 chars long")
    private String name;

    @NotNull
    @ManyToMany
    @Size(min = 1, message = "You must choose atleast 1 ingredient")
    List<Ingredient> ingredients = new ArrayList<>();

    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }
}
