package com.ems.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.entity.Employee;
import com.ems.serviceImpl.EmployeeServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin(value="http://localhost:4200")
public class EmployeeController {

	public EmployeeServiceImpl employeeService;
	
	
	
	public EmployeeController(EmployeeServiceImpl employeeService) {
		super();
		this.employeeService = employeeService;
	}



	@GetMapping("/employee")
	public List<Employee> getAllEmployee(){
		return employeeService.getEmployees();
	}
	
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> saveEmployeee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>
		(employeeService.saveEmployee(employee),HttpStatus.CREATED);
		}
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")Long id){
		return new ResponseEntity<Employee>
		(employeeService.getEmployeeById(id),HttpStatus.OK);
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee
	(@PathVariable("id") Long id,@RequestBody Employee employee){
		
		return new ResponseEntity<Employee>
		(employeeService.updateEmployee(id, employee),HttpStatus.OK);
	}
	
	@GetMapping("/employee/email/{email}")
	public ResponseEntity<Employee> 
	getByEmail2(@PathVariable("email") String email){
		System.out.println("check");
		return new ResponseEntity<Employee>
		(employeeService.getByEmail(email),HttpStatus.OK);
	}

	@DeleteMapping("/employee/{id}")
	public void deleteEmployeeById(@PathVariable("id") Long id)
	{
		employeeService.deleteById(id);
		
	}
}