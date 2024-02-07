package com.cetinbulut.carExpertise.service;

import com.cetinbulut.carExpertise.model.ExpertiseDetail;


public interface ExpertiseService {


    ExpertiseDetail getExpertiseDetailByCarId(int carId);

    void createExpertise(ExpertiseDetail expertiseDetail);
}
