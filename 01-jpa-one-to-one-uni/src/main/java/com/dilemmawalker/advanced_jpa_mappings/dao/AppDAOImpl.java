package com.dilemmawalker.advanced_jpa_mappings.dao;

import com.dilemmawalker.advanced_jpa_mappings.entity.Course;
import com.dilemmawalker.advanced_jpa_mappings.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public void remove(Instructor instructor){
        entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public List<Course> findCoursesByInstructorId(int id) {
        //create query
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data", Course.class);
        query.setParameter("data", id);

        List<Course>courses = query.getResultList();

        return courses;
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);//merge updates course
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public Course findCourseById(int id) {
        Course course = entityManager.find(Course.class, id);
        return course;
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id){
        //get instructor
        Instructor instructor = entityManager.find(Instructor.class, id);
        System.out.println("Instructor: "+ instructor);

        //get courses
        List<Course> courses = instructor.getCourses();
        System.out.println("courses: "+ courses);

        //break association of courses with instructor
        for(Course course : courses){
            course.setInstructor(null);
        }
        System.out.println("removed all courses association with instructor");

        //delete the instructor
        entityManager.remove(instructor);
        System.out.println("deleted the instructor: "+ instructor);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        //retrieve the course
        Course course = entityManager.find(Course.class, id);

        //delete the course
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }
}
