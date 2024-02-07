package com.cetinbulut.carExpertise.model;

import com.cetinbulut.carExpertise.enums.Response;
import javax.persistence.*;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "expertise_detail")
public class ExpertiseDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Enumerated(EnumType.STRING)
    private Response response;

    private String comment;

    @OneToMany(mappedBy = "expertiseDetail")
    private List<ExpertisePhoto> expertisePhotoList;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    private LocalDateTime createdDate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<ExpertisePhoto> getExpertisePhotoList() {
        return expertisePhotoList;
    }

    public void setExpertisePhotoList(List<ExpertisePhoto> expertisePhotoList) {
        this.expertisePhotoList = expertisePhotoList;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
