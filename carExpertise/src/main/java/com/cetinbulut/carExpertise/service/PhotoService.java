package com.cetinbulut.carExpertise.service;

import com.cetinbulut.carExpertise.model.ExpertisePhoto;

import java.util.List;

public interface PhotoService {
    List<String> uploadPhotos(List<ExpertisePhoto> photoList);
}
