package com.example.tacofactory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private  String id;
    @NotBlank(message = "Cannot be empty!")
    private String deliveryName;
    @NotBlank(message = "Cannot be empty!")
    private String deliveryStreet;
    @NotBlank(message = "Cannot be empty!")
    private String deliveryCity;
    @NotBlank(message = "Cannot be empty!")
    private String deliveryState;
    @NotBlank(message = "Cannot be empty!")
    private String deliveryZip;


}
