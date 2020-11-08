package com.example.inqoo.springbootcamp.hibernate.exercise1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String brand;
    private String model;
    private String engineType;
    private Integer power;
    private Integer doors;
    private String color;


    public Car(){

    }

    public Car(String brand, String model, String engineType, Integer power, Integer doors, String color) {
        this.brand = brand;
        this.model = model;
        this.engineType = engineType;
        this.power = power;
        this.doors = doors;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getEngineType() {
        return engineType;
    }

    public Integer getPower() {
        return power;
    }

    public Integer getDoors() {
        return doors;
    }

    public String getColor() {
        return color;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public void setDoors(Integer doors) {
        this.doors = doors;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineType='" + engineType + '\'' +
                ", power=" + power +
                ", doors=" + doors +
                ", color='" + color + '\'' +
                '}';
    }
}
