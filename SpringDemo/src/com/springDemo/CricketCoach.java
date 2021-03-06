package com.springDemo;

public class CricketCoach implements Coach{

	
	private FortuneService fortuneService;
	
	private String emailAddress;
	private String team;
	
	
	
	public void setEmailAddress(String emailAddress) {
		System.out.println("Cricket coach: Inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}



	public String getEmailAddress() {
		return emailAddress;
	}



	public String getTeam() {
		return team;
	}



	public void setTeam(String team) {
		System.out.println("Cricket coach: Inside setter method - setTeam");
		this.team = team;
	}



	public CricketCoach(){
		System.out.println("Cricket coach: Inside no-arg constructor");
	}
	


	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Cricket coach: Inside setter method");
		this.fortuneService = fortuneService;
	}
	

	@Override
	public String getDailyWorkout() {
		
		return "Practice fast bowling for 15 mins";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
