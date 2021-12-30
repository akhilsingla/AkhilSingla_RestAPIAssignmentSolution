package com.greatlearning.service;

import com.greatlearning.dao.EmployeeDAOJpaRepository;
import com.greatlearning.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceJpaRepositoryImpl implements EmployeeService {
    @Autowired
    private EmployeeDAOJpaRepository employeeDAOJPARepository;

    @Override
    public List<Employee> getAll() {
        return employeeDAOJPARepository.findAll();
    }

    @Override
    public Employee getById(int id) {
        Optional<Employee> employee = employeeDAOJPARepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }

        return null;
    }

    @Override
    public void save(Employee employee) {
        employeeDAOJPARepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeDAOJPARepository.deleteById(id);
    }

    @Override
    public List<Employee> sortByFirstName(String sortOrder) {
        if (sortOrder.equalsIgnoreCase("asc"))
            return employeeDAOJPARepository.findAllByOrderByFirstNameAsc();
        else if (sortOrder.equalsIgnoreCase("desc"))
            return employeeDAOJPARepository.findAllByOrderByFirstNameDesc();

        return null;
    }

    @Override
    public List<Employee> searchByFirstName(String firstName) {
        return employeeDAOJPARepository.findEmployeesByFirstName(firstName);
    }
}
