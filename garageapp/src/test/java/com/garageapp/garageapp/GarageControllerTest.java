package com.garageapp.garageapp;

import com.garageapp.garageapp.controller.GarageController;
import com.garageapp.garageapp.service.GarageService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GarageControllerTest {

    @MockBean
    private GarageService garageService;

    @Autowired
    private GarageController garageController;

    @Test
    public void testParkCarWithValidParameters() {
        String plate = "34-ABC-123";
        String color = "Black";
        String type = "Car";
        String expectedResult = "Allocated 1 slot.";

        Mockito.when(garageService.parkCar(plate, color, type)).thenReturn(expectedResult);

        ResponseEntity<String> response = garageController.parkCar(plate, color, type);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResult, response.getBody());
    }

    @Test
    public void testParkCarWithInvalidType() {
        GarageController garageController = new GarageController(garageService);
        String plate = "34-ABC-123";
        String color = "Black";
        String type = "InvalidType";
        String expectedResult = "Invalid vehicle type! Please enter car, jeep or truck.";

        Mockito.when(garageService.parkCar(plate, color, type)).thenReturn(expectedResult);

        ResponseEntity<String> response = garageController.parkCar(plate, color, type);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResult, response.getBody());
    }

    @Test
    public void testParkCarWithInvalidPlate() {
        GarageController garageController = new GarageController(garageService);
        String plate = "";
        String color = "Black";
        String type = "Car";
        String expectedResult = "Invalid info, please enter plate or color properly.";

        Mockito.when(garageService.parkCar(plate, color, type)).thenReturn(expectedResult);

        ResponseEntity<String> response = garageController.parkCar(plate, color, type);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResult, response.getBody());
    }

    @Test
    public void testParkCarWithInvalidColor() {
        GarageController garageController = new GarageController(garageService);
        String plate = "34-ABC-123";
        String color = null;
        String type = "Car";
        String expectedResult = "Invalid info, please enter plate or color properly.";

        Mockito.when(garageService.parkCar(plate, color, type)).thenReturn(expectedResult);

        ResponseEntity<String> response = garageController.parkCar(plate, color, type);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedResult, response.getBody());
    }
}
