package springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import springconfig.AnnotationConfig;
import springconfig.NoAnnotationConfig;

public class SpringApplication {

	public static void main(String[] args) {
		//load the spring config file
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(NoAnnotationConfig.class);
		//retrieve bean from spring container
		Coach coach = context.getBean("myCoach",Coach.class);
		//call methods from bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		//close the context
		context.close();
	}

}
