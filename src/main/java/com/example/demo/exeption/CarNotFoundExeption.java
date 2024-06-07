package com.example.demo.exeption;

public class CarNotFoundExeption extends RuntimeException{
    public CarNotFoundExeption(Long id){
        super("машина по " + id + " не найдена");
    }
}
