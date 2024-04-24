package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@ToString(exclude = "cars")
@Data
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.MERGE)
    private Set<Car> cars;
}
