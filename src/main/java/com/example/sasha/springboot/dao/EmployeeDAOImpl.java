package com.example.sasha.springboot.dao;

import com.example.sasha.springboot.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        Session session = entityManager.unwrap(Session.class);
//        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class).getResultList();
        Query<Employee> query = session.createQuery("from Employee ", Employee.class);
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int empId) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, empId);
        return employee;
    }

    @Override
    public void deleteEmployee(int empId) {
//        Session session = sessionFactory.getCurrentSession();
//        Employee employee = session.get(Employee.class, empId);
//        session.delete(employee);


        Session session = entityManager.unwrap(Session.class);
        Query<Employee> query = session.createQuery("delete from Employee where id =: employeeId");
        query.setParameter("employeeId", empId);
        query.executeUpdate();
    }
}
