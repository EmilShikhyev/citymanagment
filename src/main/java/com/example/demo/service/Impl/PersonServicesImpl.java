package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServices {
    private final PersonRepository personRepository;
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getAll(){
        return personRepository.findAll();
    }

    public Person getById(Long id){
        return personRepository.findById(id).orElseThrow();
    }


    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}

