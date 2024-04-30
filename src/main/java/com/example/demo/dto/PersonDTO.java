package com.example.demo.dto;

import com.example.demo.model.Car;
import lombok.Data;

import java.util.Set;
@Data
public class PersonDTO {
    Long id;
    String name;
    Set<Car> carSet;
}
