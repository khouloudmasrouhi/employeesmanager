package com.example.employeesmanager.service;

import com.example.employeesmanager.dto.EmployeeDto;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public interface IEmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto update(String id,EmployeeDto employeeDto);

    EmployeeDto getById(String id);

    List<EmployeeDto> getAll();

    public void delete(String id);

    String getClientIPAddress(HttpServletRequest request);
}
