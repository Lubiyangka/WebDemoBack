package com.webdemo.entity;

import com.webdemo.entity.enumeration.EducationBackgroundType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Enumerated
    @Column(name = "education_background", nullable = false)
    private EducationBackgroundType educationBackground;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Column(name = "student_id", unique = true, nullable = false)
    private String studentId;

    @Column(name = "phone", unique = true, nullable = false)
    private String phone;

    @Column(name = "last_time")
    private LocalDateTime lastTime;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

    @ManyToMany
    @JoinTable(name = "student_classes",
            joinColumns = @JoinColumn(name = "student_id", nullable = false))
    private List<Class> classes = new ArrayList<>();

}