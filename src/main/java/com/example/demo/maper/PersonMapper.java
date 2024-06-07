package com.example.demo.maper;

import com.example.demo.dto.PersonDTO;
import com.example.demo.model.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDTO toDTO(Person person);
    Person toEntity(PersonDTO dto);

    List<PersonDTO> listToDto(List<Person> personList);

    List<Person> listToEntity(List<PersonDTO> personDTOList);
}
