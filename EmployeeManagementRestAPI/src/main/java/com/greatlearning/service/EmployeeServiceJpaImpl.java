package com.greatlearning.service;

import com.greatlearning.dao.EmployeeDAO;
import com.greatlearning.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceJpaImpl implements EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;


    @Transactional
    @Override
    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    @Transactional
    @Override
    public Employee getById(int id) {
        return employeeDAO.getById(id);
    }

    @Transactional
    @Override
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }

    @Transactional
    @Override
    public List<Employee> sortByFirstName(String sortOrder) {
        return employeeDAO.sortByFirstName(sortOrder);
    }

    @Transactional
    @Override
    public List<Employee> searchByFirstName(String firstName) {
        return employeeDAO.searchByFirstName(firstName);
    }
}
