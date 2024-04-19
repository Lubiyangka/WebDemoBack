package com.webdemo.controller;

import com.webdemo.entity.Department;
import com.webdemo.repository.DepartmentRepository;
import com.webdemo.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Department>> getPage() {
        log.info("查询");
        List<Department> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok().body(departments);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("删除");
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department updatedDepartment) {
        Department department = departmentService.updateDepartment(updatedDepartment);
        if (department != null) {
            return ResponseEntity.ok().body(department);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
