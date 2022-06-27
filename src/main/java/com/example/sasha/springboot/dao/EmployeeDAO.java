package com.example.sasha.springboot.dao;



import com.example.sasha.springboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int empId);

    void deleteEmployee(int empId);
}
