package com.neosoft.demo.controller;

import com.neosoft.demo.exception.ResourceNotFoundException;
import com.neosoft.demo.model.Department;
import com.neosoft.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
@RequestMapping("api/p1/department")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public List<Department> getDepartment()
    {
        return departmentRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Department> getDeartmentById(@PathVariable long id)
    {
        Department dept = departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Does not exist"));
        return ResponseEntity.ok(dept);
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department)
    {
        //department.setId(null);
        return departmentRepository.save(department);
    }

    @PutMapping("{id}")
    ResponseEntity<Department> updateDepartment(@PathVariable long id, @RequestBody Department deptDetails)
    {
        Department dept = departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Does not exist"));
        dept.setName(deptDetails.getName());
        departmentRepository.save(dept);
        return ResponseEntity.ok(dept);
    }

    @DeleteMapping("{id}")
    ResponseEntity<Department> DeleteDepartment(@PathVariable long id)
    {
        Department dept = departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Does not exist"));
        departmentRepository.delete(dept);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
