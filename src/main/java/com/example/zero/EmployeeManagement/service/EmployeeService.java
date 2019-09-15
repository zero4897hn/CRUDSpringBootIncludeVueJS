package com.example.zero.EmployeeManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.zero.EmployeeManagement.entity.Employee;
import com.example.zero.EmployeeManagement.repository.EmployeeRepository;

@Service
public class EmployeeService {
	EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public Employee findById(int id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		}
		return employee;
	}
	
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}
}
