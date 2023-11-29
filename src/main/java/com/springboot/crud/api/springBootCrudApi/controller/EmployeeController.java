package com.springboot.crud.api.springBootCrudApi.controller;

import com.springboot.crud.api.springBootCrudApi.model.Employee;
import com.springboot.crud.api.springBootCrudApi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public List<Employee> get(){
        return employeeService.get();
    }

    @PostMapping("/employee")
    public Employee save(@RequestBody Employee employeeObj){
        employeeService.save(employeeObj);
        return employeeObj;
    }

    @GetMapping("/employee/{id}")
    public Employee getById(@PathVariable int id){
        Employee employee = employeeService.getById(id);
        if(employee == null)
            throw new RuntimeException("Employee with id " + id + " is not found");
        return employee;
    }

    @DeleteMapping("/employee/{id}")
    public String delete(@PathVariable int id){
        employeeService.delete(id);
        return "Employee has been deleted with id " + id;
    }

    @PutMapping("/employee")
    public Employee update(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

}
