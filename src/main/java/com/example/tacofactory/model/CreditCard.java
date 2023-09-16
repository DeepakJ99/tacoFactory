package com.example.tacofactory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@Entity
public class CreditCard {
    @Id
    private String number;
    private String expiration;
    private String CVV;
}
