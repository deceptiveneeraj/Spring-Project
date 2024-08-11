package com.school.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .authorizeHttpRequests(authorize -> authorize
            	.requestMatchers("/admin/**").authenticated()  // Restrict DELETE requests
                .requestMatchers("/students/**").permitAll()
                .anyRequest().permitAll()  // Allow all requests
            )
            .csrf().disable()  // Disable CSRF protection for testing
            .httpBasic();  // Basic authentication

        return httpSecurity.build();
    }
}
