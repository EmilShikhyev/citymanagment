package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.Impl.PersonServicesImpl;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/api/person")
@RestController
@RequiredArgsConstructor
public class PersonController {
    private final PersonServicesImpl personServices;
    @PostMapping("/create")
    public Person create(@RequestBody Person person){
        return personServices.createPerson(person);
    }

    @GetMapping("/all")
    public List<Person> getAll(){
        return personServices.getAll();
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id){
        return personServices.getById(id);
    }

    @DeleteMapping("/delete")
    public void deleteById(@PathParam("id") Long id){
        personServices.deleteById(id);
    }
}
