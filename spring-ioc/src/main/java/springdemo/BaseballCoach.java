package springdemo;

public class BaseballCoach implements Coach{	
	@Override
	public String getDailyWorkout() {
		return "spending 30 mins";
	}
}
