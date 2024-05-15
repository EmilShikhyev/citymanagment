package com.example.demo.service.Impl;

import com.example.demo.model.Car;
import com.example.demo.model.House;
import com.example.demo.model.Person;
import com.example.demo.repository.HouseRepository;
import com.example.demo.service.HouseService;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository;
    private final PersonService personService;
    @Transactional
    public House createHouse(House house){
//        Person person = personService.getById(house.getPersons().getId());
//        person.getHouses().add(house);
        return houseRepository.save(house);
    }

    public House getById(Long id){
        return houseRepository.findById(id).orElseThrow();
    }

    public List<House> getAll() {
        return houseRepository.findAll();
    }

    public void deleteById(Long id){
        houseRepository.deleteById(id);
    }

}
