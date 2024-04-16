package com.example.demo.service.Impl;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarService;
import com.example.demo.utils.MappingUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

//    private final MappingUtils mappingUtils;

    public Car createCar(Car car){
        //
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
