package com.example.demo.service.Impl;

import com.example.demo.model.Passport;
import com.example.demo.model.Person;
import com.example.demo.repository.PassportRepository;
import com.example.demo.service.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@RequiredArgsConstructor
@Service
public class PassportServiceImpl implements PassportService {
    private final PassportRepository passportRepository;


    public Passport createPassport(Person person) {
        long origin = 100000L;
        long bound = 999999L;
        Passport passport = new Passport();
        passport.setPerson(person);
        Long passportRandomNum =ThreadLocalRandom.current().nextLong(origin,bound);
        passport.setNumber(passportRandomNum);
        return passportRepository.save(passport);
    }
}
