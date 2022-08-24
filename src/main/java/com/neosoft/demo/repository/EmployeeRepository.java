package com.neosoft.demo.repository;

import com.neosoft.demo.model.Employee;
import org.apache.el.parser.JJTELParserState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
//import org.springframework.stereotype.Repository;

//@Repository :: no need to write this annotation here beacause
//Spring-data-Jpa dependency take care to add JpaRepository internally
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
    void findEmployeeDepartment();
    // all crud methods
//    @Query(value = "select e.id, d.dptId as deptId from Employee e, Department d where e.id = d.dptId;")
//    public List<EmployeeDepartment> findEmployeeDepartment();


//    @Query(value = "select new CustomEmployee ( e.id, d.dptId ) from Employee e, Department d where e.id = d.dptId;")
//    public List<CustomEmployee> findCustomEmployee();
}

//interface EmployeeDepartment
//{
// long getId();
// long getDeptId();
//}
//
//class CustomEmployee
//{
//    private long id;
//    private long dptId;
//
//    public CustomEmployee(long id, long dptId) {
//        this.id = id;
//        this.dptId = dptId;
//    }
//}