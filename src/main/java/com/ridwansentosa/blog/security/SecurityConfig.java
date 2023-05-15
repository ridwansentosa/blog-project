package com.ridwansentosa.blog.security;

import com.ridwansentosa.blog.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    //beans
    //bcrypt bean definition
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //authenticationProvider bean definition
    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService); //set the custom user details service
        auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
        return auth;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(cofigurer ->
                cofigurer
                        .requestMatchers(HttpMethod.GET, "/api/v1/posts").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/v1/posts/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/v1/posts").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/v1/posts/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/v1/posts/**").hasRole("ADMIN"));

        httpSecurity.httpBasic();

        httpSecurity.csrf().disable();

        return httpSecurity.build();
    }

/*
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT user_id, pw, active FROM members WHERE user_id=?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id=?");

        return jdbcUserDetailsManager;
    }
*/
    /*
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){

        UserDetails it = User.builder()
                .username("IT")
                .password("{noop}administrator")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        UserDetails dirga = User.builder()
                .username("dirga")
                .password("{noop}dirga123")
                .roles("EMPLOYEE")
                .build();

        UserDetails sakti = User.builder()
                .username("sakti")
                .password("{noop}sakti123")
                .roles("MANAGER")
                .build();

        return new InMemoryUserDetailsManager(it, dirga, sakti);
    }
*/
}


















