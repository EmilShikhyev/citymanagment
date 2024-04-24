package com.example.demo.service.Impl;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServicesImpl implements PersonService {
    private final PersonRepository personRepository;
//    private final MappingUtils mappingUtils;
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

