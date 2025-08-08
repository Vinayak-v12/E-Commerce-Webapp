package com.ECommerce.ECommerceApp.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {


	    @Bean
	    public DaoAuthenticationProvider daoAuthProvider(CustomUserDetailsService userDetailsService) {
	        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	        provider.setUserDetailsService(userDetailsService);
	        provider.setPasswordEncoder(passwordEncoder());
	        return provider;
	    }

	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
	            throws Exception {
	        return config.getAuthenticationManager();
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder(); // must be used when saving passwords
	    }

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf().disable()
	            .authorizeHttpRequests()
	            	.requestMatchers("/vinayak.com").permitAll()
	                .requestMatchers("/admin/**").hasRole("ADMIN")
	                .requestMatchers("/home").hasAnyRole("user", "ADMIN")
	                .anyRequest().permitAll()
	            .and()
	            .formLogin()
	            .loginPage("/login")                // optional: custom login page
	            .defaultSuccessUrl("/home", true)  
	            .and()
	            .httpBasic()
	            .and()
	            .logout();
	        return http.build();
	    }
	}


