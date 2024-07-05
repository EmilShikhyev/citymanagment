package com.example.demo.service;

import com.example.demo.model.House;
import com.example.demo.model.Person;
import com.example.demo.repository.HouseRepository;
import com.example.demo.service.Impl.HouseServiceImpl;

import java.util.List;

public interface HouseService {

    public House createHouse(House house);

    public List<House> getAll();

    public House getById(Long id);

    public void deleteById(Long id);

    public List<Person> getAllPersonsByStreet(String street);

    public House addPerson(Long houseId, Long personId);

}
