package com.garageapp.garageapp.service;

import com.garageapp.garageapp.model.Ticket;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GarageServiceImpl implements GarageService{

    private static final int MAX_SLOTS = 10;
    private final List<Boolean> slots;

    private final List<Ticket> tickets;

    public GarageServiceImpl() {
        slots = new ArrayList<>(MAX_SLOTS);
        for (int i = 0; i < MAX_SLOTS; i++) {
            slots.add(false);
        }

        tickets = new ArrayList<Ticket>();
    }

    @Override
    public String parkCar(String plate, String color, String type) {
        if(checkVehicleInfo(plate, color) == -1){
            return "Invalid info, please enter plate or color properly.";
        }
        int requiredSlots = calculateRequiredSlots(type);
        if (requiredSlots == -1){
            return "Invalid vehicle type! Please enter car, jeep or truck.";
        }
        int startIndex = findNearestAvailableSlots(requiredSlots);
        if (startIndex == -1) {
            return "Garage is full.";
        }

        Ticket ticket;
        if(checkVehicleInGarage(plate)){
            ticket = new Ticket(plate, color, new ArrayList<>());
            for (int i = startIndex; i < startIndex + requiredSlots; i++) {
                ticket.getSlots().add(i+1);
            }

            for (int i = startIndex; i < startIndex + requiredSlots; i++) {
                slots.set(i, true);
            }

            // Put a space slot to next one
            if((startIndex + requiredSlots)< MAX_SLOTS){
                slots.set(startIndex + requiredSlots, true);
            }

            tickets.add(ticket);

            return "Allocated " + requiredSlots + (requiredSlots != 1 ? " slots." : " slot.");
        }
        else {
            return  plate + " is already parked.";
        }
    }

    @Override
    public String leaveSlots(int orderNum) {
        if (orderNum < 1 || orderNum > tickets.size()) {
            return "Park order of vehicle is invalid.";
        }

        for (int i : tickets.get(orderNum-1).getSlots()) {
            slots.set(i-1, false);

            if(i < MAX_SLOTS){
                slots.set(i, false);
            }
        }

        tickets.remove(orderNum-1);

        return "Slots left successfully.";
    }

    @Override
    public String getStatus() {
        StringBuilder status = new StringBuilder("Status:\n");
        if(tickets.isEmpty()){
            status.append("The garage is empty.\n");
        }
        else {
            for (Ticket t : tickets) {
                status.append(t.toString());
            }
        }
        return status.toString();
    }

    /**
     * @param requiredSlots
     * @return finds available slot nearest to entry of the garage
     */
    private int findNearestAvailableSlots(int requiredSlots) {
        for (int i = 0; i <= MAX_SLOTS - requiredSlots; i++) {
            boolean isAvailable = true;
            for (int j = i; j < i + requiredSlots; j++) {
                if (slots.get(j)) {
                    isAvailable = false;
                    break;
                }
                if(j<MAX_SLOTS-1){
                    if (slots.get(j+1)) {
                        isAvailable = false;
                        break;
                    }
                }
            }
            if (isAvailable) {
                return i;
            }
        }
        return -1; // No available slots found
    }

    /**
     * @param plate
     * @param color
     * @return checks plate and color info is not null
     */
    private int checkVehicleInfo(String plate, String color){
        if(!StringUtils.isBlank(plate) && !StringUtils.isBlank(color))
            return 0;
        else
            return -1;
    }

    private int calculateRequiredSlots(String type) {
        // For simplicity, consider all vehicle types have different slot requirements
        if (type.equalsIgnoreCase("car")) {
            return 1;
        } else if (type.equalsIgnoreCase("truck")) {
            return 4;
        } else if (type.equalsIgnoreCase("jeep")) {
            return 2;
        } else {
            return -1; // Invalid vehicle type
        }
    }

    /**
     * @param plate
     * @return checks if the vehicle which is being parked is already in garage
     */
    private boolean checkVehicleInGarage(String plate) {
        if(!tickets.isEmpty()){
            for(Ticket t : tickets){
                if(t.getPlate().equals(plate))
                    return false;   //the vehicle is in garage
            }
        }
        return true;
    }

    public List<Ticket> getTickets() {
        return this.tickets;
    }
}