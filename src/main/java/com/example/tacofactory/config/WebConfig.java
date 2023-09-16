package com.example.tacofactory.config;

import com.example.tacofactory.model.Ingredient;
import com.example.tacofactory.service.IngredientConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    HashMap<String,Ingredient> map = new HashMap<>();
    WebConfig(){
        map.put("FLTO" ,new Ingredient("FLTO","Flour Tortilla", Ingredient.Type.WRAP));
        map.put("COTO", new Ingredient("COTO","Corn Tortilla", Ingredient.Type.WRAP));
        map.put("GRBF", new Ingredient("GRBF","Ground Beef", Ingredient.Type.PROTEIN));
        map.put("CARN",new Ingredient("CARN","Cornitoes", Ingredient.Type.PROTEIN));
        map.put("TMTO",new Ingredient("TMTO","Diced Tomato", Ingredient.Type.VEGGIES));
        map.put("LETC",new Ingredient("LETC","Lettuce", Ingredient.Type.VEGGIES));
        map.put("CHED",new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE));
        map.put("JACK", new Ingredient("JACK","Monterrey Cheese", Ingredient.Type.CHEESE));
        map.put("SLSA", new Ingredient("SLSA","Salsa", Ingredient.Type.SAUCE));
        map.put("MRNA",new Ingredient("MRNA","Marinara", Ingredient.Type.SAUCE));
    }


    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addConverter(new Converter<String, Ingredient>() {
            @Override
            public Ingredient convert(String s){
                return map.get(s);
            }
        });
    }
}
