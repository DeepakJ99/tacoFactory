package com.example.tacofactory.service;


import com.example.tacofactory.model.TacoOrder;
import com.example.tacofactory.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repo;
    public boolean save(TacoOrder order){
        repo.save(order);
        return true;
    }
}
