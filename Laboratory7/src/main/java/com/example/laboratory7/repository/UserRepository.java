package com.example.laboratory7.repository;

import com.example.laboratory7.entity.Users;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.logging.Logger;

@RequestScoped
public class UserRepository implements Serializable {

    @PersistenceContext(unitName = "default")
    private EntityManager entityManager;

    @Inject
    private Logger logger; // Assuming you have a Logger class for logging purposes

    @PostConstruct
    protected void init() {
        System.out.println("UserRepository created");
    }

    @Transactional
    public void saveUser(Users user) {
        entityManager.persist(user);
    }
}
