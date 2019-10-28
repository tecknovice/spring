package springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;	

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "run 5km";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
