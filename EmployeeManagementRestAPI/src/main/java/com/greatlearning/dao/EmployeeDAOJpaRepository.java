package com.greatlearning.dao;

import com.greatlearning.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAOJpaRepository extends JpaRepository<Employee, Integer> {
}
