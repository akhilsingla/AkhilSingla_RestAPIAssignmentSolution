package com.greatlearning.dao;

import com.greatlearning.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAOJpaRepository extends JpaRepository<Role, Integer> {
}
