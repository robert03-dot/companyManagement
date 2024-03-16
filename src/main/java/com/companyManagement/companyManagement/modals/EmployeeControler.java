package com.companyManagement.companyManagement.modals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/employees")
public class EmployeeControler {
    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeControler(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping(path = "/employeesList")
    public Iterable<Employee> getAllEmployee() {
        return employeeDAO.getAllEmployees();
    }

    @GetMapping(path = "/test")
    public String test() {
        return "TEST";
    }
    @PostMapping
    public void createEmployee(@RequestBody Employee employee){
        employeeDAO.createEmployee(employee);
    }
}
