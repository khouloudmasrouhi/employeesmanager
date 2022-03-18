package com.example.employeesmanager.dao;

import com.example.employeesmanager.model.Employee;

import java.util.List;

public interface IEmployeeDao {
    Employee addEmployee(Employee employee);

    Employee updateEmlpoyee(String id,Employee employee);

    Employee findEmployeeById(String id);

    List<Employee> findAllEmployees();

    void deleteEmployee(String id);
}
