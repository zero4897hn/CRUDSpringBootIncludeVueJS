package com.example.zero.EmployeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.zero.EmployeeManagement.service.EmployeeService;

@Controller
@RequestMapping("/")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/")
	public String Default() {
		return "index";
	}
	
	@GetMapping("/add_employee")
	public String addEmployee() {
		return "employee_add";
	}
	
	@GetMapping("/edit_employee/{id}")
	public String editEmployee(@PathVariable int id, Model model) {
		model.addAttribute("employee", employeeService.findById(id));
		return "employee_edit";
	}
}