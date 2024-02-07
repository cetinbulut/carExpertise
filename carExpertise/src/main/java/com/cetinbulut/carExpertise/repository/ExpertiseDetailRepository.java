package com.cetinbulut.carExpertise.repository;

import com.cetinbulut.carExpertise.model.ExpertiseDetail;

public interface ExpertiseDetailRepository {

    ExpertiseDetail findTopByCarIdOrderByCreatedDateDesc(int carId);


    void create(ExpertiseDetail expertiseDetail);
}
