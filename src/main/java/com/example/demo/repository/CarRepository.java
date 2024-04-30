package com.example.demo.repository;

import com.example.demo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRepository extends JpaRepository<Car,Long> {
    @Query(value = "s",nativeQuery = true)
    void deleteReference(Long personId);
}
