package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        HttpSecurity disable = http
                .authorizeHttpRequests(auth -> auth
                                .anyRequest().permitAll()  
                )
                .csrf(csrf -> csrf.disable()) 
                .formLogin(login -> login.disable()) 
                .logout(logout -> logout.disable()); 
        return http.build();
    }
}
