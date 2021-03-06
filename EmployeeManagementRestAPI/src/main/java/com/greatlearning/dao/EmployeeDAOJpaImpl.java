package com.greatlearning.dao;

import com.greatlearning.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    @Autowired
    EntityManager entityManager;

    @Override
    public List<Employee> getAll() {
        TypedQuery<Employee> query = entityManager.createQuery("from Employee ", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee getById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        Employee updatedEmployee = entityManager.merge(employee);
        employee.setId(updatedEmployee.getId());
    }

    @Override
    public void deleteById(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }

    @Override
    public List<Employee> sortByFirstName(String sortOrder) {
        Query query = entityManager.createQuery("select s from Employee as s order by s.firstName " + sortOrder, Employee.class);
        return query.getResultList();
    }

    @Override
    public List<Employee> searchByFirstName(String firstName) {
        Query query = entityManager.createQuery("select s from Employee s where s.firstName=:firstName", Employee.class);
        query.setParameter("firstName", firstName);
        return query.getResultList();
    }
}