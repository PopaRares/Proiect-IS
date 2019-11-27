package com.IS.SINU.repositories;

import com.IS.SINU.entities.dao.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserRepositoryImpl {

    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("punit");


    public void insert(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
