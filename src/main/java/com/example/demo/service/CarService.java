package com.example.demo.service;

import com.example.demo.model.Car;
import com.example.demo.model.Person;

import java.util.List;

public interface CarService {
    public Car createCar(Car car);

    public Car getById(Long id);

    public List<Car> getAll();

    public void deleteById(Long id);

    public Car update(String mark, Long id);//??

     void carSave(Car car);


}
