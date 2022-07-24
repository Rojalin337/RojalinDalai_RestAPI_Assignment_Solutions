package com.rojalin.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rojalin.employee.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> 
{
  Employee findByFirstName(String username);
}
