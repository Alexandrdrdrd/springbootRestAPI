package com.example.sasha.springboot.controllers;

import com.example.sasha.springboot.entity.Employee;
import com.example.sasha.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List<Employee> allEmployees= employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee emp = employeeService.getEmployee(id);

        System.out.println(emp);
        return emp;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

@DeleteMapping("/employees/{id}")
    public List<Employee> employees(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return showAllEmployees();
}
}
