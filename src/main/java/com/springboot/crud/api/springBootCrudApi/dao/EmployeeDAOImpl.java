package com.springboot.crud.api.springBootCrudApi.dao;

import com.springboot.crud.api.springBootCrudApi.model.Employee;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Employee> get() {
        Session session = entityManager.unwrap(Session.class); // create a session
        Query<Employee> query = session.createQuery("from Employee", Employee.class); // create a query "select"
        List<Employee> empList = query.getResultList(); // list of all employees frm table
        return empList;
    }

    @Override
    public Employee getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void save(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);
        session.delete(employee);
    }
}
