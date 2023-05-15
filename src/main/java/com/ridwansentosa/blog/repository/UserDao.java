package com.ridwansentosa.blog.repository;

import com.ridwansentosa.blog.entity.User;

public interface UserDao {
    User findByUserName(String userName);
}
