package com.companyManagement.companyManagement.modals;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    public Employee getEmployeeByEmailAddress(String emailAddress);

}