package com.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach  implements Coach {

	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService happyFortuneService) {
		fortuneService = happyFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters as a warm up";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

	
	public String getDetails() {
		return email+" \n"+team;
	}
}
