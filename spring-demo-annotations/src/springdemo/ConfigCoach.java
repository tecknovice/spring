package springdemo;

import org.springframework.stereotype.Component;

@Component
public class ConfigCoach implements Coach {

	private FortuneService fortuneService;	
	
	public ConfigCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "config spring 1h";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
