package com.example.demo.exeption;

public class HouseNotFoundExeption extends RuntimeException{
    public HouseNotFoundExeption(Long id){
        super("Дом по " + id + " не найден");
    }
}
