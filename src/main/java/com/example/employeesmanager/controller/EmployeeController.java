package com.example.employeesmanager.controller;


import com.example.employeesmanager.HttpUtils;
import com.example.employeesmanager.dto.EmployeeDto;
import com.example.employeesmanager.service.IEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final IEmployeeService employeeService;

    Logger logger= LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }



    @GetMapping("/all")
    public ResponseEntity<List<EmployeeDto>> getAllEmployee () {
        logger.trace("use my method");
        List<EmployeeDto> employees = employeeService.getAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById (@PathVariable("id") String id) {
        EmployeeDto employee = employeeService.getById(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employee){
        EmployeeDto newEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") String id,@RequestBody EmployeeDto employee){
        EmployeeDto updateEmployee = employeeService.update(id,employee);
        return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") String id){
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/client-ip-address",
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    @ResponseBody
    public String getClientIPAddress(HttpServletRequest request) {
        String ip = HttpUtils.getRequestIP(request);
        return "Client IP Address: " + ip;
    }

    @GetMapping("/clientIPAddress")
    public String index(HttpServletRequest request, Model model){
        String clientIPAddress = employeeService.getClientIPAddress(request);
        model.addAttribute("clientIPAddes",clientIPAddress);
        //return "index";
        return clientIPAddress;
    }
}



















