package com.dilemmawalker.advanced_jpa_mappings;

import com.dilemmawalker.advanced_jpa_mappings.dao.AppDAO;
import com.dilemmawalker.advanced_jpa_mappings.entity.Course;
import com.dilemmawalker.advanced_jpa_mappings.entity.Instructor;
import com.dilemmawalker.advanced_jpa_mappings.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AdvancedJpaMappingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedJpaMappingsApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructor(appDAO);
//			createInstructorWithCourses(appDAO);
//			findInstructorWithCourse(appDAO);
//			findCoursesForInstructor(appDAO);
//			updateInstructor(appDAO);
//			updateCourse(appDAO);
			deleteInstructor(appDAO);

		};
	}

	private void updateCourse(AppDAO appDAO) {
		int courseId=10;

		Course course = appDAO.findCourseById(courseId);
		course.setTitle("Enjoy simple things");

		appDAO.update(course);
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;
		//find instructor
		Instructor instructor = appDAO.findInstructorById(id);

		//update instructor
		instructor.setLastName("TESTER");
		System.out.println("updated instructor:" + instructor);

		appDAO.update(instructor);
		System.out.println("Done!");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int id=1;

		System.out.println("Finding instructor id: "+ id );

		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor: "+ instructor);

		List<Course> courses = appDAO.findCoursesByInstructorId(id);
		System.out.println("List of courses: "+ courses);
//		for(Course singleCourse: courses)
		instructor.setCourses(courses);
		System.out.println("Courses set ");

		System.out.println("associated courses: "+ instructor.getCourses());
		System.out.println("Done!");
	}

	private void findInstructorWithCourse(AppDAO appDAO) {

		int id = 1;
		System.out.println("Finding the instructor id: "+ id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("instructor: "+ instructor);
		System.out.println("associated courses: "+ instructor.getCourses());
		System.out.println("done!");
	}

	private void createInstructor(AppDAO appDAO){
//		//create instructor
//		Instructor instructor = new Instructor("Chad", "Darby", "darby@dilemmawalker.com");
//
//		//create instructor detail
//		InstructorDetail instructorDetail = new InstructorDetail("http://randomlink", "crossing paths");


		Instructor instructor = new Instructor("Madhu", "patel", "madhu@dilemmawalker.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://randomlink", "helloman");

		instructor.setInstructorDetail(instructorDetail);

		//save instructor
		System.out.println("instructor : "+ instructor);
		System.out.println("instructor details : "+ instructorDetail);
		appDAO.save(instructor);
//		appDAO.save(instructorDetail);
		System.out.println("done saving instructor & details");
	}

	private void findInstructor(AppDAO appDAO){
		int id=8;
		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Instructor details: "+ instructor);
		System.out.println("Instructor deeper details: "+ instructor.getInstructorDetail());
	}

	private void deleteInstructor(AppDAO appDAO){
		int id=19;
		appDAO.deleteInstructorById(id);
		System.out.println("deleted the instructor with id: "+ id);
	}

	public void createInstructorWithCourses(AppDAO appDAO){
		Instructor instructor = new Instructor("Susan", "public", "susan@dilemmawalker.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://randomlink", "harmony");

		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("no13");
		Course course2 = new Course("no14");
		List<Course> list = new ArrayList<>();
		list.add(course1);list.add(course2);

		instructor.setCourses(list);
//		instructor.setCourses(course2);

		appDAO.save(instructor);

		System.out.println("instructor here: "+ instructor);
		System.out.println("the courses: "+ instructor.getCourses());
	}
}
