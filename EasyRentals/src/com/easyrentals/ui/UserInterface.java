package com.easyrentals.ui;

import java.util.Set;

import com.easyrentals.model.Bike;
import com.easyrentals.service.BikeService;
import com.easyrentals.dao.BikeDAO;

public class UserInterface {
    public static void main(String[] args) {
        BikeDAO bikeService = new BikeDAO();
        Set<Bike> bikes = bikeService.getBikeDetails();
        for (Bike bike : bikes) {
            System.out.println("Bike ID: " + bike.getBikeId());
            System.out.println("Bike Name: " + bike.getBikeName());
            System.out.println("Company Name: " + bike.getCompanyName());
            System.out.println("Serial Number: " + bike.getSerialNumber());
            System.out.println("Rent Price: " + bike.getRentPrice());
            System.out.println();
        }
    }
}