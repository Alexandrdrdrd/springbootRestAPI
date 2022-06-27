package com.example.sasha.springboot.service;


import com.example.sasha.springboot.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int empId);

    public void deleteEmployee(int empId);
}
