package com.example.demo.exeptionHandler;

import com.example.demo.exeption.PersonNotFoudExeption;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExeptionHandler {
    @ExceptionHandler(PersonNotFoudExeption.class)
    public ResponseEntity<String> exeptionClientAnswer(PersonNotFoudExeption personNotFoudExeption){
        return ResponseEntity.badRequest().body(personNotFoudExeption.getMessage());
    }
}
