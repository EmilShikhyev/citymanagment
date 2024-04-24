package com.example.demo.service;

import com.example.demo.model.Car;

import java.util.List;

public interface CarService {
    public Car createCar(Car car);

    public Car getById(Long id);

    public List<Car> getAll();

    public void deleteById(Long id);

}
