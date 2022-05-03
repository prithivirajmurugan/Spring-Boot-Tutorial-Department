package com.dailycodebuffer.Springboot.tutorial.Service;

import com.dailycodebuffer.Springboot.tutorial.Entity.Department;
import com.dailycodebuffer.Springboot.tutorial.Repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;
    private Department department;
    @BeforeEach
    void setUp() {
        department = Department.builder().departmentName("IT")
                .departmentCode("IT-06")
                .departmentAddress("New Delhi")
                .departmentId(1L)
                .build();
    }

    @Test
    @DisplayName("Get Data based on Valid Department Name")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
        String departmentName = "IT";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }
    @Test
    @DisplayName("Save department to the Repository")
    public void whenSaveDepartment_thenDepartServiceShouldBeCalled(){
        Department pre_save_department = Department.builder().departmentName("IT")
                        .departmentCode("IT-06")
                .departmentAddress("New Delhi")
                                .build();

        Mockito.when(departmentRepository.save(pre_save_department)).thenReturn(department);
        departmentService.saveDepartment(department);
        Mockito.verify(departmentRepository,Mockito.times(1)).save(department);
    }
}