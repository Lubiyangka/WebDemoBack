package com.webdemo.entity;


import com.webdemo.entity.enumeration.EducationBackgroundType;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "student_id")
    private String studentId;
    @Column(name = "sex")
    private String sex;
    @Column(name = "education")
    @Enumerated(EnumType.STRING)
    private EducationBackgroundType education;
    @Column(name = "phone")
    private String phone;
    @Column(name = "discipline_time")
    private Integer disciplineTime;
    @Column(name = "deleted")
    private Boolean deleted;
}
