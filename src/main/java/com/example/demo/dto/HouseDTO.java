package com.example.demo.dto;

import com.example.demo.model.Person;
import lombok.Data;

import java.util.List;

@Data
public class HouseDTO {
    Long id;
    String address;
    List<Person> personList;
}
