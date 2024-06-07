package com.example.demo.controller;
import com.example.demo.dto.CreateCarDTO;
import com.example.demo.maper.CarMapper;
import com.example.demo.dto.CarDTO;
import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/car")
@RestController
@RequiredArgsConstructor
public class CarController {
    private final CarService carService;
    private final CarMapper carMapper;

    @PostMapping("/create")
    public CarDTO create(@RequestBody CreateCarDTO createCarDTO) {
        return carMapper.toDTO(carService.createCar(carMapper.map(createCarDTO)));
    }

    @GetMapping("/all")
    public List<CarDTO> getAll(){
        return carMapper.listToDto(carService.getAll());
    }

    @GetMapping("/{id}")
    public CarDTO getById(@PathVariable(name = "id") Long id){
        return carMapper.toDTO(carService.getById(id));
    }

    @DeleteMapping("/delete")
    public void delete(@PathParam("id")Long id){
        carService.deleteById(id); //dto?
    }


}
