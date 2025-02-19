package com.dilemmawalker.advanced_jpa_mappings.dao;

import com.dilemmawalker.advanced_jpa_mappings.entity.Instructor;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void delete(int id);
}
