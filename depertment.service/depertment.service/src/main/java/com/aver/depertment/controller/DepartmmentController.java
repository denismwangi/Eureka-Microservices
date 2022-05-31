package com.aver.depertment.controller;

import com.aver.depertment.entity.Department;
import com.aver.depertment.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departmments")
@Slf4j
public class DepartmmentController {


    private final DepartmentRepository departmentRepository;

    public DepartmmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @PostMapping("/create")
    public Department createDepartment(@RequestBody Department department){
        log.info("save department methond hit");
       return departmentRepository.save(department);

    }
    @GetMapping("/")
    public List<Department> findDepts(Department department){
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Department> findDepartmentById(@PathVariable("id") Long departmentId){
        return departmentRepository.findById(departmentId);
    }
}
