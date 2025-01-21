package com.aditya.SpringBootMVC.model;


import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
public class Alien {

    @Id
    private int aid;
    private String aname;

    public Alien(){}

    public Alien(int aid, String aname){
        this.aid = aid;
        this.aname = aname;
    }

    public int getAid() {
        return aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                '}';
    }
}
