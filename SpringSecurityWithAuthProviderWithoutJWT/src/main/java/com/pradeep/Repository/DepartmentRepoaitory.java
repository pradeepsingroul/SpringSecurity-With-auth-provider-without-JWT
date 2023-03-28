package com.pradeep.Repository;

import com.pradeep.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepoaitory extends JpaRepository<Department,Integer> {




}
