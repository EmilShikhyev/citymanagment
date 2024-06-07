package com.example.demo.maper;

import com.example.demo.dto.CarDTO;
import com.example.demo.dto.CreateCarDTO;
import com.example.demo.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    @Mapping(target = "id",source = "id") // напомнить
    @Mapping(target = "model",constant = "new")
    CarDTO toDTO(Car car);

    @Mapping(target = "person.id",source = "personId")
    Car toEntity(CarDTO dto);

    List<CarDTO> listToDto(List<Car> carList);

    List<Car> listToEntity(List<CarDTO> carDTOList);

    @Mapping(target = "id", expression = "java(null)")
    @Mapping(target = "person", expression = "java(null)")
    Car map(CreateCarDTO createCarDTO);
}
