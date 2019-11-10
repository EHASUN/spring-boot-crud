package com.app.template;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.template.domain.Course;
import com.app.template.domain.CourseRepository;
import com.app.template.domain.Student;
import com.app.template.domain.StudentRepository;
import com.app.template.domain.User;
import com.app.template.domain.UserRepository;

@SpringBootApplication
public class ApplicationMain {
	
	private static final Logger log = LoggerFactory.getLogger(ApplicationMain.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationMain.class, args);
	}
	
	/**
	 * Save demo users and students to
	 * @param repository
	 * @return
	 */
	@Bean
	public CommandLineRunner demo(StudentRepository repository, CourseRepository crepository, UserRepository urepository) {
		return (args) -> {
			// save students
			Student student1 = new Student("Abul", "Hasan", "Tech", "test@mail.com");
			repository.save(new Student("Rashed", "Rahman", "Sales", "test@mail.com"));
			repository.save(new Student("Jakir", "Hossain", "Management", "test@mail.com"));
			repository.save(new Student("Bari", "Hasan", "Production","test@mail.com"));
			repository.save(new Student("Nabi", "Ullah", "Marketing","test@mail.com"));
			
			Course course1 = new Course("Course 1");
			Course course2 = new Course("Course 2");
			crepository.save(new Course("Course 3"));
			crepository.save(new Course("Course 4"));
			
			crepository.save(course1);
			crepository.save(course2);
			
			Set<Course> courses = new HashSet<Course>();
			courses.add(course1);
			courses.add(course2);
			
			student1.setCourses(courses); 
			repository.save(student1);

			// Create users with BCrypt encoded password (user/user, admin/admin)
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$08$bCCcGjB03eulCWt3CY0AZew2rVzXFyouUolL5dkL/pBgFkUH9O4J2", "ADMIN");
			//urepository.save(user1);
			//urepository.save(user2);
		};
	}
}
