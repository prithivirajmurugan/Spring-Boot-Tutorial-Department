package com.dailycodebuffer.Springboot.tutorial.controller;

import com.dailycodebuffer.Springboot.tutorial.Entity.Department;
import com.dailycodebuffer.Springboot.tutorial.Service.DepartmentService;
import com.dailycodebuffer.Springboot.tutorial.error.DepartmentNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    private DepartmentService departmentService;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    public DepartmentController(DepartmentService service) {
        this.departmentService = service;
    }


    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> getDepartments(){
        LOGGER.info("Inside getDepartments of DepartmentController");
        return departmentService.getAllDepartments();
    }
    @GetMapping("/departments/{id}")
    public Department getDepartment(@PathVariable("id") Long Id) throws DepartmentNotFoundException {
        return departmentService.getDepartmentById(Id);
    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long Id){
        departmentService.deleteDepartmentById(Id);
        return "Department deleted Successfully!!!";

    }
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department) {
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
