package com.greatlearning.service;

import com.greatlearning.dao.RoleDAOJpaRepository;
import com.greatlearning.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceJpaRepositoryImpl implements RoleService {

    @Autowired
    RoleDAOJpaRepository roleDAOJpaRepository;

    @Override
    public void addRole(Role role) {
        roleDAOJpaRepository.save(role);
    }
}
