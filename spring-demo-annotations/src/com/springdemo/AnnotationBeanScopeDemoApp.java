package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		
		// load the spring config file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		// retrieve bean from spring container
		Coach coach1 = context.getBean("tennisCoach",Coach.class);
		Coach coach2 = context.getBean("tennisCoach",Coach.class);
		
		boolean result = (coach1 == coach2);
		System.out.println("Pointing to the same object: "+ result);
		
		
		// close the context
		context.close();
	}
}