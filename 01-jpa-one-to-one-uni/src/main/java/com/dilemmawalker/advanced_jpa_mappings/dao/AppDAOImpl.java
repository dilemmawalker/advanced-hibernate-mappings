package com.dilemmawalker.advanced_jpa_mappings.dao;

import com.dilemmawalker.advanced_jpa_mappings.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDAO{

    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor){
        entityManager.persist(instructor);
        //doing persist on instructor automatically saves instructor_detail as well as we have set cascade type to all.
    }

    @Override
    @Transactional
    public Instructor findInstructorById(int id){
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void delete(int id){
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.remove(instructor);
    }
}
