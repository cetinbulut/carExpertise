package com.garageapp.garageapp.service;

public interface GarageService {
    String parkCar(String plate, String color, String type);

    String leaveSlots(int orderNum);

    String getStatus();
}
