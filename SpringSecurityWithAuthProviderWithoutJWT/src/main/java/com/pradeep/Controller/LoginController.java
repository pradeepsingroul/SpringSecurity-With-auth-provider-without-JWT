package com.pradeep.Controller;

import com.pradeep.Model.Employee;
import com.pradeep.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LoginController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees/signin")
    private ResponseEntity<Employee> getLoggenInEmployee(Authentication auth){
        Optional<Employee> optEmployee = employeeRepository.findByEmail(auth.getName());
        if(optEmployee.isPresent()){
            Employee employee = optEmployee.get();
            return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
        }else{
            throw new BadCredentialsException("employe does not exits with id :"+auth.getName());
        }
    }




}
