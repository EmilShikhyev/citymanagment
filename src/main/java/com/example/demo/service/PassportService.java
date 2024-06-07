package com.example.demo.service;

import com.example.demo.model.Passport;
import com.example.demo.model.Person;

public interface PassportService {
    Passport createPassport(Person person);
}
