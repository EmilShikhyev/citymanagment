package com.example.demo.service;

import com.example.demo.model.House;
import com.example.demo.service.Impl.HouseServiceImpl;

import java.util.List;

public interface HouseService {
    public House createHouse(House house);

    public List<House> getAll();

    public House getById(Long id);

    public void deleteById(Long id);
}
