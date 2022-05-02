package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
				
		
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			
			session.beginTransaction();
			
			
			// query the students
			List<Student> students = session.createQuery("from Student").getResultList();
			
			
			// display students
			for(Student s:students) {
				System.out.println(s);
			}
			System.out.println();
			
			
			students = session.createQuery("from Student s where s.lastName='Jam'").getResultList();
			for(Student s:students) {
				System.out.println(s);
			}
			System.out.println();
			
			
			students = session.createQuery("from Student s where s.firstName='Jim' or s.email like 'Bonita%'").getResultList();
			for(Student s:students) {
				System.out.println(s);
			}
			System.out.println();
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
