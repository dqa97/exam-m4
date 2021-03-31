package com.codegym.examm4.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double area;
    private int population;
    private int GDP;
    private String description;

    @ManyToOne
    private Country country;
}
