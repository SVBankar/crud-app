package com.neosoft.demo.controller;

import com.neosoft.demo.exception.ResourceNotFoundException;
import com.neosoft.demo.model.Employee;
import com.neosoft.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //capable to handle http request
@RequestMapping(path = "/api/p1/employees")  // common base url for this restApi
public class EmployeeController
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees()
    {
        System.out.println("Fetching....");
        System.out.println("Fetch....");
        System.out.println("Fetching....");
        employeeRepository.findEmployeeDepartment();
        return employeeRepository.findAll();
    }

    // build create employee REST api
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) // @RequestBody will convert JSON into java object
    {
        return employeeRepository.save(employee);
    }

    // build get employee by id REST api
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id)
    {
        Employee employee = employeeRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Employee not exist"));
        return ResponseEntity.ok(employee);
        // ok method internally provides 200 STATUS code
    }

    // build update employee REST api
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails)
    {
        Employee updateEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Does not exist"));
        updateEmployee.setName(employeeDetails.getName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());
        //updateEmployee.setDepartment(employeeDetails.getDepartment());
        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);
    }

    // build delete employee REST api
    @DeleteMapping("{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable long id)
    {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Does not exist"));
        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT); // we are not returning anything to client
    }
}