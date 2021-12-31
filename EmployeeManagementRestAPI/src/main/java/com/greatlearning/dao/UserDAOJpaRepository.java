package com.greatlearning.dao;

import com.greatlearning.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserDAOJpaRepository extends JpaRepository<User, Integer> {
    @Query("select s from User s where s.username=:name")
    User findUser(@Param("name") String username);
}
