package com.pradeep.Services;

import com.pradeep.Exceptions.DepartmentException;
import com.pradeep.Model.Department;
import com.pradeep.Model.Employee;

import java.util.List;
import java.util.Optional;

public interface DepartmentServices {

    public Department registerDepartment(Department department)throws DepartmentException;

    public Department getDepartmentDetails(int departid) throws DepartmentException;





}
