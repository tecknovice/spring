package springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigCoach.class);
		Coach coach = context.getBean("configCoach",Coach.class);
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		context.close();
	}

}
