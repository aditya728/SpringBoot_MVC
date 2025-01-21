package com.aditya.SpringBootMVC.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlienRepo extends JpaRepository<Alien, Integer> {

    List<Alien> findByAname(String aname); //Query DSL (Domain-Specific Language)
    // --> means follow the rule and jpa will automatically provide the query based on our variable names

    //OR we can also do it by ourselves
    @Query("from Alien where aname = :name") //JPQL
    List<Alien> findUsingName(@Param("name") String aname);

}
