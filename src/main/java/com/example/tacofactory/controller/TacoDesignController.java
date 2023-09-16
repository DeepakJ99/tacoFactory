package com.example.tacofactory.controller;


import com.example.tacofactory.model.Ingredient;
import com.example.tacofactory.model.Taco;
import com.example.tacofactory.model.TacoOrder;
import com.example.tacofactory.service.IngredientConverter;
import com.example.tacofactory.service.IngredientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class TacoDesignController {

    @Autowired
    private IngredientService ingredientService;
    @GetMapping
    public String getPage(){
        return "design";
    }

    @ModelAttribute
    public  void addIngredients(Model model){

        Ingredient.Type[] types = Ingredient.Type.values();
        for(Ingredient.Type type : types){
            model.addAttribute(type.toString().toLowerCase(), ingredientService.getByType(type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order(){
        return new TacoOrder();
    }

    @ModelAttribute(name =  "taco")
    public Taco taco(){return  new Taco();}






    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8"})
    public String processTaco(@Valid Taco taco,
                              Errors errors,
                              @ModelAttribute TacoOrder tacoOrder){

        if(errors.hasErrors()){

            return "design";
        }
        tacoOrder.addTaco(taco);
        return "redirect:/orders/current";
    }
}
