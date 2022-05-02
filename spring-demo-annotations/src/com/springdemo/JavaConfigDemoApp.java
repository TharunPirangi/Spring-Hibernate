package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {
	public static void main(String args[]) {
		
		// read the spring config file java
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from the spring container
		
		SwimCoach theCoach = context.getBean("swimCoach",SwimCoach.class);
		
		// call a method on the bean
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		
		System.out.println(theCoach.getDetails());
		
		
		// close the context
		
		context.close();
	}
}