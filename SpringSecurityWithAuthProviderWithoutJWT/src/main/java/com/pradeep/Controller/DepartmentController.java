package com.pradeep.Controller;

import com.pradeep.Model.Department;
import com.pradeep.Services.DepartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentServices departmentServices;

    @PostMapping("/departments")
    public ResponseEntity<Department> registerDepartmentHandler(@RequestBody Department department){
        Department department1 = departmentServices.registerDepartment(department);
        return new ResponseEntity<>(department1, HttpStatus.CREATED);
    }

    @GetMapping("/departments/{departId}")
    public ResponseEntity<Department> getDepartmentDetails(@PathVariable Integer departId){
        Department department = departmentServices.getDepartmentDetails(departId);
        return  new ResponseEntity<>(department,HttpStatus.OK);
    }


}
