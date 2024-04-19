package com.webdemo.controller;

import com.webdemo.repository.StudentRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentResource {
    private final StudentRepository studentRepository;


    public StudentResource(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void test(){
        studentRepository.findAll();
    }


}
