package com.rojalin.employee.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rojalin.employee.exception.ResourceNotFoundException;
import com.rojalin.employee.model.Employee;
import com.rojalin.employee.repository.EmployeeRepository;
import com.rojalin.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl  implements EmployeeService{

	
	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		return employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
		
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		// we need to check whether employee with given id is exist in DB or not
				Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
						() -> new ResourceNotFoundException("Employee", "Id", id)); 
				
				existingEmployee.setFirstName(employee.getFirstName());
				existingEmployee.setLastName(employee.getLastName());
				existingEmployee.setEmail( employee.getEmail());
				// save existing employee to DB
				employeeRepository.save(existingEmployee);
				return existingEmployee;
	}

	@Override
	public void deleteEmployee(long id) {
		employeeRepository.findById(id).orElseThrow(() -> 
		new ResourceNotFoundException("Employee", "Id", id));
employeeRepository.deleteById(id);
		
	}

}
