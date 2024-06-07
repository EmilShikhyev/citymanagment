package com.example.demo.service.Impl;

import com.example.demo.exeption.CarNotFoundExeption;
import com.example.demo.model.Car;
import com.example.demo.model.Person;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarService;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public Car createCar(Car car){
        return carRepository.save(car);
    }

    public Car getById(Long id){
        return carRepository.findById(id).orElseThrow(() -> new CarNotFoundExeption(id));
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public void deleteById(Long id){
         carRepository.deleteById(id);
    }


    @Override
    public Car update(String mark, Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new CarNotFoundExeption(id));
        car.setMark(mark);
        return carRepository.save(car);
    }

    @Override
    public void carSave(Car car) {
        carRepository.save(car);
    }
}
