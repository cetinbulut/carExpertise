package com.cetinbulut.carExpertise.repository;

import com.cetinbulut.carExpertise.model.ExpertiseDetail;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

@Repository("expertiseDetailRepository")
public class ExpertiseDetailRepositoryImpl implements ExpertiseDetailRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ExpertiseDetail findTopByCarIdOrderByCreatedDateDesc(int carId) {

        String query = "from ExpertiseDetail e WHERE e.carId = :carId ORDER BY e.createdDate DESC";
        return (ExpertiseDetail) entityManager.createQuery("from ExpertiseDetail where car.id = :carId order by createdDate DESC")
                .setParameter("carId", carId).getSingleResult();
    }

    @Override
    public void create(ExpertiseDetail expertiseDetail) {
        entityManager.persist(expertiseDetail);
    }
}
