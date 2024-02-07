package com.cetinbulut.carExpertise.controller;

import com.cetinbulut.carExpertise.model.ExpertiseDetail;
import com.cetinbulut.carExpertise.service.ExpertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class ExpertiseController {

    @Autowired
    private ExpertiseService expertiseService;

    @GetMapping("/expertise/{carId}")
    public ResponseEntity<ExpertiseDetail> getExpertiseDetail(@PathVariable("carId") int carId) {
        try {
            ExpertiseDetail expertiseDetail = expertiseService.getExpertiseDetailByCarId(carId);
            return ResponseEntity.ok(expertiseDetail);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/expertise/create", method = RequestMethod.POST)
    public ResponseEntity<URI> createExpertise(@RequestBody ExpertiseDetail expertiseDetail) {
        try {
            expertiseService.createExpertise(expertiseDetail);
            ExpertiseDetail savedDetail = expertiseService.getExpertiseDetailByCarId(expertiseDetail.getCar().getId());
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedDetail.getId()).toUri();
            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
