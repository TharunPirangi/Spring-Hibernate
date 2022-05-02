package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	public static void main(String args[]) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
				
		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a student object
			System.out.println("Creating new student object!");
			
			Student tempStudent1 = new Student("paul","Wall","paul@gmail.com");
			Student tempStudent2 = new Student("Mary","Public","Mary@gmail.com");
			Student tempStudent3 = new Student("Bonita","Apple","Bonita@gmail.com");
			
			
			// start a transaction
			
			session.beginTransaction();
			
			
			// save the student object
			System.out.println("Saving the student object..");
			
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}
}
