package com.ems.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ems.entity.Employee;
import com.ems.exception.ResourceNotFoundException;
import com.ems.repository.EmployeeRepository;
import com.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService  {
	
	public EmployeeRepository employeeRepository;
	
	


	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}




	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}




	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}




	@Override
	public Employee getEmployeeById(Long id) {
		return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("not found"));
		
			
	}




	@Override
	public Employee updateEmployee(Long id, Employee employee) {
	
	Employee emp=employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not found"));
	
	emp.setFirstName(employee.getFirstName());
	emp.setEmail(employee.getEmail());
	emp.setLastName(employee.getLastName());
	
	return employeeRepository.save(emp);
	}




	@Override
	public Employee getByEmail(String email) {
		System.out.println("check");
	Employee emp= employeeRepository.findByEmail(email);
	System.out.println(emp);
	return emp;
	}

	@Override
	public void deleteById(Long id) {
		Employee emp = employeeRepository.findById(id).orElseThrow
		(()->new ResourceNotFoundException("Not found"));
			
		if(emp != null) {
			employeeRepository.deleteById(id);
		}
		
		}
}
