package com.ems.service;

import java.util.List;

import com.ems.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> getEmployees();
	public Employee saveEmployee(Employee employee);
	public Employee getEmployeeById(Long id);
	public Employee updateEmployee(Long id, Employee employee);
	public Employee getByEmail(String email);
	public void deleteById(Long id);
	

}
