package com.example.tacofactory.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class TacoOrder {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;

    @ManyToOne
    private Address address;




    @OneToMany(cascade = CascadeType.ALL)
    private List<Taco> tacos = new ArrayList<>(0);
    public void addTaco(Taco t){
        tacos.add(t);
    }

}
