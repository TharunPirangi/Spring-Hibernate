package com.springdemo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
	private FortuneService fortuneService;
	
	@Override
	public String getDailyWorkout() {
		return "Pracitce your backhand volley";
	}
	
	
	public TennisCoach() {
		System.out.println("TennisCoach: Inside constructor");
	}
	
	
	@PostConstruct
	public void startUpWork() {
		System.out.println("Hello");
	}
	
//	@Autowired
//	public TennisCoach(FortuneService fortuneService){
//		this.fortuneService = fortuneService;
//	}
	
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
