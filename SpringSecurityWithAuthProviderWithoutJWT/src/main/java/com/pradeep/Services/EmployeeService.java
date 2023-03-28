package com.pradeep.Services;

import com.pradeep.Exceptions.EmployeeException;
import com.pradeep.Model.Employee;

import java.util.Optional;

public interface EmployeeService {

    public Employee registerEmployee(Employee employee)throws  EmployeeException;

    public Employee getEmployeeDetails(String email) throws EmployeeException;




}
