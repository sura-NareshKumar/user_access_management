package com.example.useraccessmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> {
			try {
				requests
				        .requestMatchers("/signup", "/login").permitAll()
				        .requestMatchers("/admin/**").hasRole("Admin")
				        .requestMatchers("/manager/**").hasRole("Manager")
				        .requestMatchers("/employee/**").hasRole("Employee")
				        .and().formLogin().loginPage("/login").defaultSuccessUrl("/dashboard", true)
				        .and().logout().logoutSuccessUrl("/login");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
