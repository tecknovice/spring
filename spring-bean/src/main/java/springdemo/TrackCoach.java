package springdemo;

public class TrackCoach implements Coach {	
	@Override
	public String getDailyWorkout() {
		return "run 5km";
	}
	public void initMethod() {	
		System.out.println("inside initMethod");
	}
	public void destroyMethod() {	
		System.out.println("inside destroyMethod");
	}
}
