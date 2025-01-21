package com.aditya.SpringBootMVC;

import com.aditya.SpringBootMVC.model.Alien;
import com.aditya.SpringBootMVC.model.AlienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//This class is made for the PostMan REST practice

@RestController
public class AlienController {

    @Autowired
    AlienRepo repo;

    @GetMapping("aliens")
//    @ResponseBody //tells that this method has to send direct data and dont apply prefix suffix
    public List<Alien> getAliens(){
        List<Alien> aliens = repo.findAll();
        return aliens;
    }

    @GetMapping("alien/{aid}")
//    @ResponseBody
    public Alien getAlien(@PathVariable("aid") int aid){
        Alien alien = repo.findById(aid).orElse(new Alien(0, ""));
        return alien;
    }

    @PostMapping("alien")
//    @ResponseBody
    public Alien addAlien(Alien a){
        repo.save(a);
        return a;
    }
}
