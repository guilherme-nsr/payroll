package com.example.payroll;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class EmployeeController {
	private final EmployeeRepository repository;
	
	EmployeeController(EmployeeRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/employees")
	List<Employee> all() {
		return repository.findAll();
	}
	
	@PostMapping("/employees")
	Employee newEmployee(@RequestBody Employee employee) {
		return repository.save(employee);
	}
	
	@GetMapping("/employee/{id}")
	Employee one(@PathVariable Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new EmployeeNotFoundException(id));
	}
}
