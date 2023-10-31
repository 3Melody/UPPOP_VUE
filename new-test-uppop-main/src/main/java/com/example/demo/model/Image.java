package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Image {

    @Id
    @Column(name = "ID_img")
    private Long id;

     @Column(name = "url")
    private String url; 


}
