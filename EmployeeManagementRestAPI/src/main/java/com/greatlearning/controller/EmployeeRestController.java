package com.greatlearning.controller;

import com.greatlearning.entity.Employee;
import com.greatlearning.errorHandler.EmployeeNotFoundException;
import com.greatlearning.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    @Autowired
    @Qualifier("employeeServiceJpaRepositoryImpl")
    EmployeeService employeeService;

    @GetMapping("/")
    public List<Employee> getEmployees() {
        return employeeService.getAll();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        Employee employee = employeeService.getById(employeeId);
        if (employee == null)
            throw new EmployeeNotFoundException("Not found employee having id : " + employeeId);

        return employee;
    }

    @PostMapping("/")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    @PutMapping("/")
    public Employee updateEmployee(@RequestBody Employee employee) {

        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        if (employeeService.getById(employeeId) == null)
            throw new EmployeeNotFoundException("Not found employee having id : " + employeeId);
        employeeService.deleteById(employeeId);
        return "Deleted employee having id : " + employeeId;
    }

    @GetMapping("/sort")
    public List<Employee> getSortedListOfEmployees(@RequestParam("order") String sortOrder) throws Exception {
        if (!sortOrder.equalsIgnoreCase("asc") && !sortOrder.equalsIgnoreCase("desc"))
            throw new Exception("Please provide correct sort order, accepted order :- asc,ASC,desc,DESC");
        return employeeService.sortByFirstName(sortOrder);
    }

    @GetMapping("/search/{searchString}")
    public List<Employee> searchEmployeedOnFirstName(@PathVariable String searchString) {
        List<Employee> employeeList = employeeService.searchByFirstName(searchString);
        if (employeeList.isEmpty() || employeeList == null)
            throw new EmployeeNotFoundException("Not found employee having first name : " + searchString);

        return employeeList;
    }
}
