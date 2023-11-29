package com.springboot.crud.api.springBootCrudApi.service;

import com.springboot.crud.api.springBootCrudApi.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> get();
    Employee getById(int id);
    void save(Employee employee);
    void delete(int id);
}
