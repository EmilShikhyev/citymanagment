package com.example.demo.maper;

import com.example.demo.dto.CarDTO;
import com.example.demo.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {
    @Mapping(target = "id",source = "id")
    @Mapping(target = "model",constant = "new")
    CarDTO toDTO(Car car);

    Car toEntity(CarDTO dto);
}
