package com.example.demo.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "person_activity")
public class PersonActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @Column(name = "date_time_add")
    private Date dateTimeAdd;

    
    // getters and setters
}
