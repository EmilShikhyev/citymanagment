package com.example.demo.controller;


import com.example.demo.model.House;
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

    @PostMapping("/create")
    public House create(@RequestBody House house){
        return houseService.createHouse(house);
    }

    @GetMapping("/all")
    public List<House> getAll(){
        return houseService.getAll();
    }

    @GetMapping("/{id}")
    public House getById(@PathVariable Long id){
        return houseService.getById(id);
    }

    @DeleteMapping("/delete")
    public void deleteById(@PathParam("id") Long id){
        houseService.deleteById(id);
    }
}
