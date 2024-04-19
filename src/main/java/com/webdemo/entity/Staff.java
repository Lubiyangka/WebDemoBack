package com.webdemo.entity;

import com.webdemo.entity.enumeration.StaffType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "staff_id", nullable = false, unique = true)
    private String staffId;

    @Column(name = "picture")
    private String picture;

    @Column(name = "sex", nullable = false)
    private String sex;

    @Enumerated
    @Column(name = "job")
    private StaffType job;

    @Column(name = "start")
    private LocalDate start;

    @Column(name = "last_time")
    private LocalDateTime lastTime;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted;

}