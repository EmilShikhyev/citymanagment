package com.example.demo.service.Impl;

import com.example.demo.exeption.HouseNotFoundExeption;
import com.example.demo.model.Car;
import com.example.demo.model.House;
import com.example.demo.model.Person;
import com.example.demo.repository.HouseRepository;
import com.example.demo.service.HouseService;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository;
    @Lazy
    @Autowired
    private PersonService personService;
    @Transactional
    public House createHouse(House house){
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

    @Override
    public List<Person> getAllPersonsByStreet(String street) {
        street = "%" + street + "%";
        List<House> houseList = houseRepository.getHousesByStreet(street);
        return houseList.stream().
                flatMap(house -> house.getPersons().stream())
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public House addPerson(Long houseId, Long personId) {
        Person person = personService.getById(personId);
        House house = houseRepository.findById(houseId).orElseThrow(() -> new HouseNotFoundExeption(houseId)); //TODO : Выбрасывать исключение если нет дома и перехватывать
        house.getPersons().add(person);
        person.getHouses().add(house);
        houseRepository.save(house);
        personService.update(person);
        return house;
    }

    }

