package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;
import com.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
				
		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create the objects
			
			Instructor tempInstructor = new Instructor("John", "Wick", "john@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("https://www.youtube.com/john","coding");
			
			
			
			// associate the objects
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			
			// save the instructor
			
			// because of CascadeType.All if we save tempInstructor tempInstructorDetail will also
			// be saved automatically 
			
			System.out.println("Saving instructor");
			session.save(tempInstructor);
			
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
		}
		finally {
			factory.close();
		}
	}

}
