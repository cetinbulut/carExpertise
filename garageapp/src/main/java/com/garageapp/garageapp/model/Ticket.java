package com.garageapp.garageapp.model;

import java.util.List;

public class Ticket {
    private String plate;
    private String color;
    private List<Integer> slots;

    public Ticket(String plate, String color, List<Integer> slots) {
        this.plate = plate;
        this.color = color;
        this.slots = slots;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Integer> getSlots() {
        return slots;
    }

    public void setSlots(List<Integer> slots) {
        this.slots = slots;
    }

    @Override
    public String toString() {
        return plate + " " + color + " " + slots + "\n";
    }
}
