package com.example.demo.exeption;

public class PersonNotFoudExeption extends RuntimeException{
    public PersonNotFoudExeption(Long id) {
        super("Житель по id " + id + " не найден");
    }
}
