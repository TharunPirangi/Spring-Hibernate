package com.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		
		// retrieve bean from spring container
		
		Coach coach1 = context.getBean("myCoach",Coach.class);
		Coach coach2 = context.getBean("myCoach", Coach.class);
		
		
		boolean sameObjects = (coach1 == coach2);
		System.out.println("Pointing to the same object: "+ sameObjects);
		
		System.out.println("Memory location of coach1: "+coach1);
		System.out.println("Memory location of coach2: "+coach2);
		
		// call methods 
		
		
		// close the context
		
		context.close();
		
	}

}