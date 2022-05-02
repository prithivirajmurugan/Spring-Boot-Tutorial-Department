package com.dailycodebuffer.Springboot.tutorial.Repository;

import com.dailycodebuffer.Springboot.tutorial.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findByDepartmentNameIgnoreCase(String departmentName);
}
/*
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
*/