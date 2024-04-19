package com.webdemo.entity;


import com.webdemo.entity.enumeration.StaffType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "staff")
public class Staff implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "department_id")
    private Long departmentId;
    @Column(name = "name")
    private String name;
    @Column(name = "picture")
    private String picture;
    @Column(name = "job")
    @Enumerated(EnumType.STRING)
    private StaffType job;
    @Column(name = "start")
    private LocalDate start;
    @Column(name = "end")
    private LocalDate lastTime;
    @Column(name = "deleted")
    private Boolean deleted;
}
