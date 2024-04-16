package com.example.demo.service;

import com.example.demo.model.Person;

import java.util.List;

public interface PersonService {
    public Person createPerson(Person person);

    public List<Person> getAll();

    public Person getById(Long id);

    public void deleteById(Long id);
}
