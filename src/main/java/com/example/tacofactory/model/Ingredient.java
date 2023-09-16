package com.example.tacofactory.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ingredient {

    @Id
    private String id;
    private  String name;
    private  Type type;


    public enum  Type{
        WRAP,
        SAUCE,
        PROTEIN,
        VEGGIES,
        CHEESE
    }
}
