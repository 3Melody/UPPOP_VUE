package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
@Table(name = "participate")
public class participate {

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


}
