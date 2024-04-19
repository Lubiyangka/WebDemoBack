package com.webdemo.entity;

import com.webdemo.entity.enumeration.EducationBackgroundType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "class")
public class Class implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "teacer_id")
    private Long teacherId;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "start")
    private LocalDate start;
    @Column(name = "end")
    private LocalDate end;
    @Column(name = "deleted")
    private Boolean deleted;
}
