package springdemo;

import org.springframework.stereotype.Component;

@Component("myCoach")
public class BaseballCoach implements Coach{	
	@Override
	public String getDailyWorkout() {
		return "spending 30 mins";
	}
}
