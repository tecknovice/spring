package springdemo;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {	
	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "run 5km";
	}
}
