package com.example.demo.exeptionHandler;

import com.example.demo.exeption.CarNotFoundExeption;
import com.example.demo.exeption.HouseNotFoundExeption;
import com.example.demo.exeption.PersonNotFoudExeption;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExeptionHandler {
    @ExceptionHandler(PersonNotFoudExeption.class)
    public ResponseEntity<String> exeptionClientAnswer(PersonNotFoudExeption personNotFoudExeption) {
        return ResponseEntity.badRequest().body(personNotFoudExeption.getMessage());
    }

    @ExceptionHandler(HouseNotFoundExeption.class)
    public ResponseEntity<String> exeptionClientAnswer(HouseNotFoundExeption houseNotFoundExeption) {
        return ResponseEntity.badRequest().body(houseNotFoundExeption.getMessage());
    }

    @ExceptionHandler(CarNotFoundExeption.class)
    public ResponseEntity<String> exeptionClientAnswer(CarNotFoundExeption carNotFoundExeption) {
        return ResponseEntity.badRequest().body(carNotFoundExeption.getMessage());
    }
}
