package com.example.demo.controller;


import com.example.demo.dto.HouseDTO;
import com.example.demo.dto.PersonDTO;
import com.example.demo.maper.HouseMapper;

import com.example.demo.maper.PersonMapper;
import com.example.demo.model.Person;
import com.example.demo.service.HouseService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/house")
@RestController
@RequiredArgsConstructor
public class HouseController {
    private final HouseService houseService;

    private final HouseMapper houseMapper;

    private final PersonMapper personMapper;

    @PostMapping("/create")
    public HouseDTO create(@RequestBody HouseDTO houseDTO){
        return houseMapper.toDTO(houseService.createHouse(houseMapper.toEntity(houseDTO)));
    }

    @GetMapping("/all")
    public List<HouseDTO> getAll(){
        return houseMapper.listToDto(houseService.getAll());
    }

    @GetMapping("/{id}")
    public HouseDTO getById(@PathVariable Long id){
        return houseMapper.toDTO(houseService.getById(id));
    }

    @DeleteMapping("/delete")
    public void deleteById(@PathParam("id") Long id){
        houseService.deleteById(id);
    }

    @GetMapping("/persons")
    public List<PersonDTO> getAllPersonsByStreet(@PathParam("street") String street){
        return personMapper.listToDto(houseService.getAllPersonsByStreet(street));
    }
    @PutMapping("/addperson")
    public void addPersonbyId(@PathParam(value = "houseId") Long houseId, @PathParam(value = "personId") Long personId){
        houseService.addPerson(houseId,personId);
    }
}
