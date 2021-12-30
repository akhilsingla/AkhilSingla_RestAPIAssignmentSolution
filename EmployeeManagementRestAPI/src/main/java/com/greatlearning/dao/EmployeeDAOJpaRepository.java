package com.greatlearning.dao;

import com.greatlearning.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDAOJpaRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByOrderByFirstNameAsc();
    List<Employee> findAllByOrderByFirstNameDesc();
    List<Employee> findEmployeesByFirstName(String firstName);
}
