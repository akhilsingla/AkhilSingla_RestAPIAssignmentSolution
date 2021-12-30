package com.greatlearning.controller;

import com.greatlearning.entity.Role;
import com.greatlearning.service.RoleService;
import com.greatlearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RolesRestController {

    @Autowired
    @Qualifier("roleServiceJpaImpl")
    private RoleService roleService;

    @PostMapping("/roles")
    public void addRole(@RequestBody Role role)
    {
        roleService.addRole(role);
    }
}
