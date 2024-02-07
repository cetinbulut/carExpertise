package com.cetinbulut.carExpertise.model;

import javax.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Entity
@Table(name = "expertise_photo")
public class ExpertisePhoto
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "expertise_detail_id")
    private ExpertiseDetail expertiseDetail;
    private String url;
    private LocalDateTime createdDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ExpertiseDetail getExpertiseDetail() {
        return expertiseDetail;
    }

    public void setExpertiseDetail(ExpertiseDetail expertiseDetail) {
        this.expertiseDetail = expertiseDetail;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
