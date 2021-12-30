package com.greatlearning.dao;

import com.greatlearning.entity.User;

public interface UserDao {

    public void addUser(User user);

    public User findByUsername(String userName);

}
