package com.example.sasha.springboot.service;

import com.example.sasha.springboot.dao.EmployeeDAO;
import com.example.sasha.springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDAO employeeDAO;

    @Transactional
    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }

    @Transactional
    @Override
    public Employee getEmployee(int empId) {
        return employeeDAO.getEmployee(empId);
    }

    @Transactional
    @Override
    public void deleteEmployee(int empId) {
        employeeDAO.deleteEmployee(empId);
    }
}
