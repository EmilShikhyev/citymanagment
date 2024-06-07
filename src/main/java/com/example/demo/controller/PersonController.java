package com.example.demo.controller;

import com.example.demo.dto.CarDTO;
import com.example.demo.dto.PersonDTO;
import com.example.demo.maper.CarMapper;
import com.example.demo.maper.PersonMapper;
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
    private final PersonMapper personMapper;
    private final CarMapper carMapper;
    @PostMapping("/create")
    public PersonDTO create(@RequestBody PersonDTO personDTO){
        return personMapper.toDTO(personServices.createPerson(personMapper.toEntity(personDTO)));
    }

    @GetMapping("/all")
    public List<PersonDTO> getAll(){
        return personMapper.listToDto(personServices.getAll());
    }

    @GetMapping("/{id}")
    public PersonDTO getById(@PathVariable(name = "id") Long id){
        return personMapper.toDTO(personServices.getById(id));
    }

    @DeleteMapping("/delete")
    public void deleteById(@PathParam("id") Long id){
        personServices.deleteById(id);
    }

//    public PersonDTO update(@RequestBody){
//
//    }
    @PutMapping("/addcar")
    public PersonDTO addCar(@RequestBody CarDTO carDTO, @PathParam(value = "id") Long id){
       var personAdd = personServices.addCar(carMapper.toEntity(carDTO),id);
       return personMapper.toDTO(personAdd);
    }
}
