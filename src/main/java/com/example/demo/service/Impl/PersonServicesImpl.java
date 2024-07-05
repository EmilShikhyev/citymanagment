package com.example.demo.service.Impl;

import com.example.demo.exeption.PersonNotFoudExeption;
import com.example.demo.model.Car;
import com.example.demo.model.House;
import com.example.demo.model.Passport;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.CarService;
import com.example.demo.service.HouseService;
import com.example.demo.service.PassportService;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class PersonServicesImpl implements PersonService {
    private final PersonRepository personRepository;
    private final PassportService passportService;
    private final CarService carService;
    private final HouseService houseService;
    @Transactional
    public Person createPerson(Person person) {
        Person savedPerson = personRepository.save(person);
        person.setPassport(passportService.createPassport(person));
        return savedPerson;
    }

    public List<Person> getAll(){
        return personRepository.findAll();
    }

    public Person getById(Long id){
        return personRepository.findById(id).orElseThrow(()-> new PersonNotFoudExeption(id));
    }
    @Transactional
    public void deleteById(Long id) {
        personRepository.deleteById(id);// удалять паспорт
    }

    public Person update(Person person){
      return personRepository.save(person);
    }

    @Transactional // house repo, car repo?
    public void update(String name, Long id){
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoudExeption(id));
        person.setName(name);
        personRepository.save(person);

    }

    @Transactional // house repo?
    public Person addHouse(House house, Long personId){
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new PersonNotFoudExeption(personId));
        person.getHouses().add(house);
       return personRepository.save(person);
    }

    @Transactional
    @Override
    public Person addCar(Car car, Long personId) {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new PersonNotFoudExeption(personId));
        person.getCars().add(car);
        var carSave = carService.getById(car.getId());
        carSave.setPerson(person);
        carService.carSave(car);
        return personRepository.save(person);

    }
}

