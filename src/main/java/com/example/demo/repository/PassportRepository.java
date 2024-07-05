package com.example.demo.repository;

import com.example.demo.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PassportRepository extends JpaRepository<Passport,Long> {

    @Query(nativeQuery = true,
            value = "SELECT number FROM passport JOIN person ON passport.id = person.id WHERE name LIKE :letter%"
    )
    List<Long> getPassportNumberByPersons(@Param("letter") String letter);

}
