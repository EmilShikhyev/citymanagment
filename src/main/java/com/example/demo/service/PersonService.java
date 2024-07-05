package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.model.House;
import com.example.demo.model.Person;

import java.util.List;
import java.util.Set;

public interface PersonService {
    public Person createPerson(Person person);

    public List<Person> getAll();

    public Person getById(Long id);

    public void deleteById(Long id);

    public Person update(Person person);

    public void update(String name, Long id);

    public Person addHouse(House house, Long personId);

    public Person addCar(Car car, Long personId);
}
