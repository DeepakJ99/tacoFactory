package com.example.tacofactory.controller;

import com.example.tacofactory.model.Address;
import com.example.tacofactory.model.TacoOrder;
import com.example.tacofactory.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @GetMapping("/current")
    public String showAddressForm(Model model){
        return "addressForm";
    }

    @PostMapping
    public String processOrder(TacoOrder tacoOrder, SessionStatus sessionStatus){
        sessionStatus.setComplete();
        orderService.save(tacoOrder);
        return "redirect:/design";
    }
    @ModelAttribute("address")
    public Address address(){
        return new Address();
    }
}
