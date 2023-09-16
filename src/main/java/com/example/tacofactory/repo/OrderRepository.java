package com.example.tacofactory.repo;

import com.example.tacofactory.model.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder,String> {
}
