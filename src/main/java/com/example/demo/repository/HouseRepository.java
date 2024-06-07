package com.example.demo.repository;

import com.example.demo.model.House;
import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HouseRepository extends JpaRepository<House,Long> {

    @Query(value = "select House from House h where h.address ilike :street")
    List<House> getHousesByStreet(@Param("street") String street);
}
