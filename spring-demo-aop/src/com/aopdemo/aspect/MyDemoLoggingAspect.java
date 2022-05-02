package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	// this is where we add our related advices for logging
	
	// lets start with @Before advice
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("So this prints before add account");
	}
}
