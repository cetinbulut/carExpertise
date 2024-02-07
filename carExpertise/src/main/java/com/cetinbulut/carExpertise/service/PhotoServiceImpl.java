package com.cetinbulut.carExpertise.service;

import com.cetinbulut.carExpertise.model.ExpertisePhoto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService{


    /**
     * This is a dummy func. Photo upload operation will be done by mobile app
     * @param photoList
     * @return dummy data
     */
    @Override
    public List<String> uploadPhotos(List<ExpertisePhoto> photoList){

        //photos uploaded by mobile app

        List<String> uploadedPhotoURLs = new ArrayList<>();
        uploadedPhotoURLs.add("https://www.tiktakkirala.com/cmsfiles/sliders/tiktak-neo-1.png");
        uploadedPhotoURLs.add("https://www.tiktakkirala.com/cmsfiles/sliders/tiktak-neo-1.png");
        uploadedPhotoURLs.add("https://www.tiktakkirala.com/cmsfiles/sliders/tiktak-neo-1.png");
        return uploadedPhotoURLs;   // dummy data
    }
}
