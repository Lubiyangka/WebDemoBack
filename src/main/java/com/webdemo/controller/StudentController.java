package com.webdemo.controller;

import com.webdemo.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentRepository studentRepository;


    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


//    public ResponseEntity<> test(){
//        log.info("查询");
//        studentRepository.findAll();
//        return ResponseEntity.ok().build();
//    }


}
