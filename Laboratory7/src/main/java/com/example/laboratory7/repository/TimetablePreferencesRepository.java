package com.example.laboratory7.repository;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;

import java.io.Serializable;

@RequestScoped
public class TimetablePreferencesRepository implements Serializable {

        @PersistenceContext(unitName = "default")
        private EntityManager entityManager;

        @PostConstruct
        protected void init() {
            System.out.println("TimetablePreferencesRepository created");
        }

}
