package com.example.demo.maper;

import com.example.demo.dto.HouseDTO;
import com.example.demo.model.House;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HouseMapper {
    HouseDTO toDTO(House house);

    House toEntity(HouseDTO houseDTO);

    List<HouseDTO> listToDto(List<House> houseList);

    List<House> listToEntity(List<HouseDTO> houseDTOList);
}
