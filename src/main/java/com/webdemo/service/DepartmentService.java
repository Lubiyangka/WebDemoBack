package com.webdemo.service;

import com.webdemo.entity.Department;
import com.webdemo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findByDeletedFalse();
    }

    public void deleteDepartment(Long id) {
        Optional<Department> optional = departmentRepository.findById(id);
        if (optional.isPresent()) {
            Department department = optional.get();
            department.setDeleted(true);
            departmentRepository.save(department);
        }
    }

    public Department updateDepartment(Department updatedDepartment) {
        Optional<Department> optionalDepartment = departmentRepository.findById(updatedDepartment.getId());
        if (optionalDepartment.isPresent()) {
            Department department = optionalDepartment.get();
            department.setName(updatedDepartment.getName());
            department.setLastTime(LocalDateTime.now());
            return departmentRepository.save(department);
        } else {
            return null;
        }
    }
}
