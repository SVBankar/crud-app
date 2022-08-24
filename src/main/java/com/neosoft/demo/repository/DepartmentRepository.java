package com.neosoft.demo.repository;

import com.neosoft.demo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {


}
