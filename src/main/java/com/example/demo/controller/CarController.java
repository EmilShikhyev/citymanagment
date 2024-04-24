package com.example.demo.controller;

import com.example.demo.dto.CarDTO;
import com.example.demo.maper.CarMaper;
import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/car")
@RestController
public class CarController {
    private final CarService carService;
    private final CarMaper carMaper;

    public CarController(CarService carService, CarMaper carMaper) {
        this.carService = carService;
        this.carMaper = carMaper;
    }

    @PostMapping("/create")
    public Car create(@RequestBody Car car){
        return carService.createCar(car);
    }

    @GetMapping("/all")
    public List<Car> getAll(){
        return carService.getAll();
    }

    @GetMapping("/{id}")
    public CarDTO getById(@PathVariable(name = "id") Long id){
        return carMaper.map(carService.getById(id));
    }

    @DeleteMapping("/delete")
    public void delete(@PathParam("id")Long id){
        carService.deleteById(id);
    }


}
