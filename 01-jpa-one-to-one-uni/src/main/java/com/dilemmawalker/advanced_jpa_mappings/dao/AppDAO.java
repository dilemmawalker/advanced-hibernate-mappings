package com.dilemmawalker.advanced_jpa_mappings.dao;

import com.dilemmawalker.advanced_jpa_mappings.entity.Course;
import com.dilemmawalker.advanced_jpa_mappings.entity.Instructor;

import java.util.List;

public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void delete(int id);

    List<Course> findCoursesByInstructorId(int id);

    void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(int id);
}
