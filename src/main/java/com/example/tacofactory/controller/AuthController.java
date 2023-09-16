package com.example.tacofactory.controller;


import com.example.tacofactory.DTO.RegisterForm;
import com.example.tacofactory.model.User;
import com.example.tacofactory.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class AuthController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/register")
    public String registerPage(){
        return  "register";
    }

    @PostMapping(
            path="/auth/register",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE+"; charset=UTF-8"}
    )
    public String doRegistration(RegisterForm registerForm){
        User u = User.builder()
                .email(registerForm.getEmail())
                .password(encoder.encode(registerForm.getPassword()))
                .build();
        repo.save(u);
        return "redirect:/login";
    }


}
