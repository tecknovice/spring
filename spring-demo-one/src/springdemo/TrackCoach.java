package springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;	
	
	public TrackCoach() {
	}

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
		// TODO Auto-generated method stub
		return null;
	}
	
	//add init method
	public void init() {
		System.out.println("init method");
	}
	//add destroy method
	public void destroy() {
		System.out.println("destroy method");
	}
}
