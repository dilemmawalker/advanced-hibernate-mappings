package com.dilemmawalker.advanced_jpa_mappings;

import com.dilemmawalker.advanced_jpa_mappings.dao.AppDAO;
import com.dilemmawalker.advanced_jpa_mappings.entity.Course;
import com.dilemmawalker.advanced_jpa_mappings.entity.Instructor;
import com.dilemmawalker.advanced_jpa_mappings.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
			createInstructorWithCourses(appDAO);

		};
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
		int id=6;
		appDAO.delete(id);
		System.out.println("deleted the instructor with id: "+ id);
	}

	public void createInstructorWithCourses(AppDAO appDAO){
		Instructor instructor = new Instructor("Susan", "public", "susan@dilemmawalker.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://randomlink", "harmony");

		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("hello");
		Course course2 = new Course("pin");

		instructor.setCourses(course1);
		instructor.setCourses(course2);

		appDAO.save(instructor);

		System.out.println("instructor here: "+ instructor);
	}
}
