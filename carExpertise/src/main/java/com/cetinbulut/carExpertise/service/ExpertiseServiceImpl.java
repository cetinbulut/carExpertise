package com.cetinbulut.carExpertise.service;

import com.cetinbulut.carExpertise.model.ExpertiseDetail;
import com.cetinbulut.carExpertise.model.ExpertisePhoto;
import com.cetinbulut.carExpertise.repository.ExpertiseDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpertiseServiceImpl implements ExpertiseService {

    private ExpertiseDetailRepository expertiseDetailRepository;

    @Autowired
    public void setExpertiseDetailRepository(ExpertiseDetailRepository expertiseDetailRepository){
        this.expertiseDetailRepository = expertiseDetailRepository;
    }

    @Override
    public ExpertiseDetail getExpertiseDetailByCarId(int carId) {
        // bring latest expertise
        ExpertiseDetail detail = expertiseDetailRepository.findTopByCarIdOrderByCreatedDateDesc(carId);
        return detail;
    }

    @Override
    public void createExpertise(ExpertiseDetail expertiseDetail) {
        expertiseDetailRepository.create(expertiseDetail);
    }
}
