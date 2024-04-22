package com.garageapp.garageapp;

import com.garageapp.garageapp.model.Ticket;
import com.garageapp.garageapp.service.GarageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GarageServiceTest {

    @Autowired
    private GarageServiceImpl garageService;

    @BeforeEach
    public void setUp(){
        garageService = new GarageServiceImpl();
    }

    @Test
    public void testParkCarWithValidParameters() {
        String plate = "34-ABC-123";
        String color = "Black";
        String type = "Car";

        String result = garageService.parkCar(plate, color, type);

        assertEquals("Allocated 1 slot.", result);
    }

    @Test
    public void testParkCarWithInvalidType() {
        String plate = "34-ABC-123";
        String color = "Black";
        String type = "InvalidType";

        String result = garageService.parkCar(plate, color, type);

        assertEquals("Invalid vehicle type! Please enter car, jeep or truck.", result);
    }

    @Test
    public void testParkCarWithInvalidPlate() {
        String plate = "";
        String color = "Black";
        String type = "Car";

        String result = garageService.parkCar(plate, color, type);

        assertEquals("Invalid info, please enter plate or color properly.", result);
    }

    @Test
    public void testParkCarWithInvalidColor() {
        String plate = "34-ABC-123";
        String color = null;
        String type = "Car";

        String result = garageService.parkCar(plate, color, type);

        assertEquals("Invalid info, please enter plate or color properly.", result);
    }

    @Test
    public void testParkSameCarAgain() {
        garageService.parkCar("34-ASD-123", "Black", "Car");
        String result = garageService.parkCar("34-ASD-123", "Black", "Car");

        assertEquals("34-ASD-123 is already parked.", result);
    }

    @Test
    public void testLeaveWithValidOrderNumber() {
        garageService.parkCar("34-ASD-123", "Black", "Car");
        List<Ticket> tickets = garageService.getTickets();
        int ticketsBefore = tickets.size();
        String result = garageService.leaveSlots(1);
        tickets = garageService.getTickets();
        int ticketsAfter = tickets.size();
        assertEquals("Slots left successfully.", result);
        assertEquals(ticketsBefore - 1, ticketsAfter);
    }

    @Test
    public void testLeaveWithInvalidOrderNumber() {
        String result = garageService.leaveSlots(3);

        assertEquals("Park order of vehicle is invalid.", result);
    }

    @Test
    public void testGetStatusWithEmptyGarage() {
        String result = garageService.getStatus();

        assertTrue(result.contains("The garage is empty."));
    }

    @Test
    public void testGetStatusWithNonEmptyGarage() {
        garageService.parkCar("34-ASD-123", "Black", "Car");

        String result = garageService.getStatus();

        assertFalse(result.contains("The garage is empty."));
        assertTrue(result.contains("34-ASD-123 Black [1]"));
    }
}
