package com.example.payroll;

import org.springframework.web.bind.annotation.RestController;

@RestController
class EmployeeController {
	private final EmployeeRepository repository;
	
	EmployeeController(EmployeeRepository repository) {
		this.repository = repository;
		System.out.println(this.repository);
	}
}
