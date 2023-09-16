package com.example.tacofactory.service;

import com.example.tacofactory.model.Ingredient;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientConverter implements Converter<String, Ingredient> {
    private Map map = new HashMap<>();

    public IngredientConverter(){

    }

    @Override
    public Ingredient convert(String s) {
        return (Ingredient) map.get(s);
    }

    @Override
    public JavaType getInputType(TypeFactory typeFactory) {
        return null;
    }
    @Override
    public JavaType getOutputType(TypeFactory typeFactory) {
        return null;
    }
}
