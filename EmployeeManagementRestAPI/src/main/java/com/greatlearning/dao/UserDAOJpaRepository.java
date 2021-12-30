package com.greatlearning.dao;

import com.greatlearning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAOJpaRepository extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
}
