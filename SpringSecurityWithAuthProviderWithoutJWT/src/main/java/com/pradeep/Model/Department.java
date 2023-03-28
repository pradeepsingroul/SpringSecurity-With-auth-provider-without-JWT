package com.pradeep.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    private String deptName;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "department")
    private List<Employee> employees = new ArrayList<>();

}
