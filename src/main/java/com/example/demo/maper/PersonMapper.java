package com.example.demo.maper;

import com.example.demo.dto.PersonDTO;
import com.example.demo.model.Person;
import org.mapstruct.Mapper;

@Mapper
public interface PersonMapper {
    PersonDTO toDTO(Person person);
    Person toEntity(PersonDTO dto);
}
