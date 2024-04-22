package com.garageapp.garageapp.controller;

import com.garageapp.garageapp.service.GarageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/garage")
public class GarageController {
    private final GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @PostMapping("/park")
    public ResponseEntity<String> parkCar(@RequestParam String plate, @RequestParam String color, @RequestParam String type) {
        return ResponseEntity.ok(garageService.parkCar(plate, color, type));
    }

    @PostMapping("/leave")
    public ResponseEntity<String> leaveSlots(@RequestParam int orderNum) {
        return ResponseEntity.ok(garageService.leaveSlots(orderNum));
    }

    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok(garageService.getStatus());
    }
}