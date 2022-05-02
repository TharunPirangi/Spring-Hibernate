package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
				
		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a student object
			System.out.println("Creating new student object!");
			
			Student tempStudent = new Student("Jim","Jam","Jim@gmail.com");
			
			
			// start a transaction
			
			session.beginTransaction();
			
			
			// save the student object
			System.out.println("Saving the student object..");
			
			session.save(tempStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			
			
			// Create new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			// commit the transaction
			
			session.getTransaction().commit();
			
			
			System.out.println(myStudent);
			
			
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
