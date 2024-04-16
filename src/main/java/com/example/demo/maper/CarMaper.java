package com.example.demo.maper;

import com.example.demo.dto.CarDTO;
import com.example.demo.model.Car;
import org.mapstruct.Mapper;

@Mapper
public interface CarMaper {
    CarDTO map(Car car);
}
