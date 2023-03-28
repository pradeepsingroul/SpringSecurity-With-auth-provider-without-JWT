package com.pradeep.Services;

import com.pradeep.Exceptions.DepartmentException;
import com.pradeep.Model.Department;
import com.pradeep.Repository.DepartmentRepoaitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentServices{

    @Autowired
    private DepartmentRepoaitory departmentRepoaitory;

    @Override
    public Department registerDepartment(Department department) {
        return departmentRepoaitory.save(department);
    }

    @Override
    public Department getDepartmentDetails(int departid) {
        Optional<Department> optionalDepartment = departmentRepoaitory.findById(departid);
        if(optionalDepartment.isPresent()){
            return optionalDepartment.get();
        }else{
            throw new DepartmentException("Department does not exist with the id :"+departid);
        }
    }
}
