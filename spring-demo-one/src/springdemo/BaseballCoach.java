package springdemo;

public class BaseballCoach implements Coach{
	
	private FortuneService fortuneService;
	//define constructor for DI
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	@Override
	public String getDailyWorkout() {
		return "spending 30 mins";
	}
	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
}
