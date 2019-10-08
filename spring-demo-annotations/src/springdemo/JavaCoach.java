package springdemo;

import org.springframework.stereotype.Component;

@Component
public class JavaCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "study java course on Udemy for 8h";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
