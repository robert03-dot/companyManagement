package com.companyManagement.companyManagement.modals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDAO {
    @Autowired
    private EmployeeRepository repository;
    public List<Employee> getAllEmployees(){
        List<Employee> list = new ArrayList<>();
        Streamable.of(repository.findAll()).forEach(list::add);
        return list;
    }
    public void createEmployee(Employee employee) {
        Optional<Employee> employeeOptional = Optional.ofNullable(repository.getEmployeeByEmailAddress(employee.getEmailAddress()));
        if(employeeOptional.isPresent()){
            throw new RuntimeException("The employee object already exists");
        }
        repository.save(employee);
    }
}