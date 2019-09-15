package com.example.zero.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.zero.EmployeeManagement.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
