package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
				
		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			// Create new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			int studentId = 1;
			
			System.out.println("Deleting student with id: "+studentId);
			Student myStudent = session.get(Student.class, studentId);
			
			session.delete(myStudent);
			
			
			// commit the transaction
			
			session.getTransaction().commit();
			
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
