package com.greatlearning.service;

import com.greatlearning.dao.RoleDao;
import com.greatlearning.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RoleServiceJpaImpl implements RoleService{

    @Autowired
    RoleDao roleDao;

    @Override
    @Transactional
    public void addRole(Role role) {
        roleDao.addRole(role);
    }
}
