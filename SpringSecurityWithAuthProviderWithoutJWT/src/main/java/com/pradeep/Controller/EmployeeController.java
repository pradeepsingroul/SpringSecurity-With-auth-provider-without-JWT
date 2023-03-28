package com.pradeep.Controller;

import com.pradeep.Model.Employee;
import com.pradeep.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/employees/{email}")
    public ResponseEntity<Employee> getEmployeeUserNameHandler(@PathVariable String email){
        Employee employee = employeeService.getEmployeeDetails(email);
        return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> registerEmployeeUserNameHandler(@RequestBody Employee employee){
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        Employee employee1 = employeeService.registerEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
    }







}
