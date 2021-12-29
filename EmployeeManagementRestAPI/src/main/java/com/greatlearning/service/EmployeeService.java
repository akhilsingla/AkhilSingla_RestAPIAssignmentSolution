package com.greatlearning.service;

import com.greatlearning.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAll();

    public Employee getById(int id);

    public void save(Employee employee);

    public void deleteById(int id);
}
