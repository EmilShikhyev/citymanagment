package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService{
    private final CarRepository carRepository;

    public Car createCar(Car car){
        return carRepository.save(car);
    }

    public Car getById(Long id){
        return carRepository.findById(id).orElseThrow();
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public void deleteById(Long id){
         carRepository.deleteById(id);
    }

}
