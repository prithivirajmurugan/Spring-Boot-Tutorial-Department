package com.dailycodebuffer.Springboot.tutorial.Service;

import com.dailycodebuffer.Springboot.tutorial.Entity.Department;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long Id) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long id);

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);
}
