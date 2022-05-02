package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Course;
import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Review;
import com.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentsDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
				
		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// create a course
			
			Course tempCourse = new Course("Pacman-How to score");
			
			// save the course
			System.out.println("saving the course");
			session.save(tempCourse);
			System.out.println("Saved the course: "+tempCourse);
			
			// create student
			Student student1 = new Student("John", "Doe","john@gmail.com");
			Student student2 = new Student("Kim", "depp","kim@gmail.com");
			
			// add students to the course
			
			tempCourse.addStudent(student1);
			tempCourse.addStudent(student2);
			
			// save the students
			System.out.println("Saving students..");
			session.save(student1);
			session.save(student2);
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
