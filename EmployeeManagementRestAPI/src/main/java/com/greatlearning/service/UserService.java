package com.greatlearning.service;

import com.greatlearning.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{

    public void addUser(User user);

    public User findByUserName(String userName);
}
