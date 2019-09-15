package com.example.zero.EmployeeManagement.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.zero.EmployeeManagement.entity.Employee;
import com.example.zero.EmployeeManagement.service.EmployeeService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {
	EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	public List<Employee> getEmployeesList() {
		return employeeService.findAll();
	}

	@PostMapping("/insert")
	public void save(@RequestBody String data) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonNode = mapper.readTree(data);
			Employee employee = new Employee();
			if (jsonNode.has("firstName")) {
				employee.setFirstName(jsonNode.get("firstName").asText());
			}
			if (jsonNode.has("lastName")) {
				employee.setLastName(jsonNode.get("lastName").asText());
			}
			if (jsonNode.has("email")) {
				employee.setEmail(jsonNode.get("email").asText());
			}
			employeeService.save(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/find/{id}")
	public Employee findById(@PathVariable("id") int id) {
		return employeeService.findById(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody String data) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonNode = mapper.readTree(data);
			Employee employee = null;
			if (jsonNode.has("id")) {
				employee = employeeService.findById(jsonNode.get("id").asInt());
			}
			if (jsonNode.has("firstName")) {
				employee.setFirstName(jsonNode.get("firstName").asText());
			}
			if (jsonNode.has("lastName")) {
				employee.setLastName(jsonNode.get("lastName").asText());
			}
			if (jsonNode.has("email")) {
				employee.setEmail(jsonNode.get("email").asText());
			}
			employeeService.save(employee);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		try {
			employeeService.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
