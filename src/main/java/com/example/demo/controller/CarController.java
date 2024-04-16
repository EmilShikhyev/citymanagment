package com.example.demo.controller;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;
import com.example.demo.service.Impl.CarServiceImpl;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/car")
@RestController
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
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
    public Car getById(@PathVariable Long id){
        return carService.getById(id);
    }

    @DeleteMapping("/delete")
    public void delete(@PathParam("id")Long id){
        carService.deleteById(id);
    }


}
