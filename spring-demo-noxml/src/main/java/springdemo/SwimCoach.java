package springdemo;

public class SwimCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "swim 1000m";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
