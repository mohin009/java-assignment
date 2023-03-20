package com.easyrentals.dao;

import com.easyrentals.model.Bike;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class BikeDAO {

    public Set<Bike> getBikeDetails() {
        Set<Bike> bikeSet = new HashSet<>();

        Bike bike1 = new Bike(1001, "Hon:1001", "CBR", 500.0, "Honda");
        bike1.setRentDate(LocalDate.of(2023, 3, 20));
        Bike bike2 = new Bike(1002, "Her:1002", "CBZ", 800.0, "Hero");
        bike2.setRentDate(LocalDate.of(2023, 3, 21));
        Bike bike3 = new Bike(1003, "Enf:1001", "Bullet", 900.0, "Enfield");
        bike3.setRentDate(LocalDate.of(2023, 3, 22));
        Bike bike4 = new Bike(1004, "Her:1004", "Karizma", 700.0, "Hero");
        bike4.setRentDate(LocalDate.of(2023, 3, 23));

        bikeSet.add(bike1);
        bikeSet.add(bike2);
        bikeSet.add(bike3);
        bikeSet.add(bike4);

        return bikeSet;
    }
}