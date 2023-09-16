package com.example.tacofactory.config;


import com.example.tacofactory.model.User;
import com.example.tacofactory.repo.UserRepository;
import com.example.tacofactory.security.CustomFilter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableWebMvc
@AllArgsConstructor
public class SecurityConfig {
    @Autowired
    private final UserRepository repo;

    @Autowired
    private final CustomFilter filter;
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();

    }

    @Bean
    public UserDetailsService userDetailsService(){
//        return new InMemoryUserDetailsManager(Arrays.asList(
//           new User("deepak",encoder.encode("password"),Arrays.asList(new SimpleGrantedAuthority("USER")))
//        ));
        return username -> {
             User u = repo.findByEmail(username);
             if(u != null) return u;
             throw new UsernameNotFoundException(String.format("User %s not found!",username));
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .authorizeHttpRequests(a->a.requestMatchers("/"))
//                .csrf(c->c.disable())
//                .cors(c->c.disable())
//                .authorizeHttpRequests(auth-> auth
//
//                        .requestMatchers("/design","/orders")
//                        .hasRole("USER")
//                        .requestMatchers("/","/**").permitAll())
//
//                .formLogin(form->form
//                        .loginPage("/login")
//                        .loginProcessingUrl("/auth/login")
//                        .usernameParameter("email")
//                        .passwordParameter("password")
//                        .defaultSuccessUrl("/deign")
//                        )
//                .logout(l->l
//                        .logoutSuccessUrl("/"))

                .build();
    }

}
