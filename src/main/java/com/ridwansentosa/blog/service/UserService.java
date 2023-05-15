package com.ridwansentosa.blog.service;


import com.ridwansentosa.blog.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User findByUserName(String userName);
}
