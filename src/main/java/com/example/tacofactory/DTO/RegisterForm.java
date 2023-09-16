package com.example.tacofactory.DTO;


import lombok.Builder;
import lombok.Data;


@Builder
@Data
public class RegisterForm {

    public String email;
    public String password;
}
