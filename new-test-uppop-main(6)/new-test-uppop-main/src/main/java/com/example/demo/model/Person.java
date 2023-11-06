package com.example.demo.model;



import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_user")
    private Long idUser;

    @Column(name = "username")
    private String username;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "email")
    private String email;

    @Column(name = "typeuser")
    private String typeUser;

    @Column(name = "password")
    private String password;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    



    // getters and setters
}
