package com.employee.employee.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.employee.employee.model.Employee;
import com.employee.employee.repositories.EmployeeRepository;



@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
   
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping
	public List<Employee> list(){
		return employeeRepository.findAll();
	}
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody Employee empl) {
		employeeRepository.save(empl);
	}
	@GetMapping("/{id}")
	public Employee get(@PathVariable("id") long id) {
		return employeeRepository.getOne(id);
		//return new Employee();
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") long id) {
		 employeeRepository.deleteById(id);
		//return new Employee();
	}
	
}
