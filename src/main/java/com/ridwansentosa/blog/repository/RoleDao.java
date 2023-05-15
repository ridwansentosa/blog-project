package com.ridwansentosa.blog.repository;

import com.ridwansentosa.blog.entity.Role;

public interface RoleDao {
    public Role findRoleByName(String theRoleName);
}
