package springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	private FortuneService fortuneService;
	
	@Value("${foo.email}")
	private String email;
	@Value("${foo.name}")
	private String name;
	
	public SwimCoach(springdemo.FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "swim 1Km";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
