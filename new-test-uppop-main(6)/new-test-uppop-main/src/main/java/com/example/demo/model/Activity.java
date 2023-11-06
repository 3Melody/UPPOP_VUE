package com.example.demo.model;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "activity")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_activity")
    private Long idActivity;

    @Column(name = "date_start")
    private LocalDate date_Start;

    @Column(name = "time_start")
    private LocalTime time_Start;

    @Column(name = "date_end")
    private LocalDate date_end;

    @Column(name = "time_end")
    private LocalTime time_end;

    @Column(name = "location")
    private String location;

    @Column(name = "nameactivity")
    private String nameActivity;

    @Column(name = "category")
    private String category;

    @Column(name = "ID_img")
    private Long id_img;

    @Column(name = "detail")
    private List<String> detail;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "id_admin")
    private Long id_admin;

    
    
}
