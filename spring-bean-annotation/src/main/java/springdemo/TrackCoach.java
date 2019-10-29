package springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//  bean có scope là prototype sẽ không được ApplicationContext gọi callback destroy-method
@Component
//@Scope("singleton")
@Scope("prototype")
public class TrackCoach implements Coach {	
	@Override
	public String getDailyWorkout() {
		return "run 5km";
	}
	@PostConstruct
	public void initMethod() {	
		System.out.println("inside initMethod");
	}
	@PreDestroy
	public void destroyMethod() {	
		System.out.println("inside destroyMethod");
	}
}
