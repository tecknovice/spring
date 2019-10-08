package springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		//get bean from container
		SwimCoach coach = context.getBean("swimCoach",SwimCoach.class);
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		System.out.println(coach.getEmail());
		System.out.println(coach.getName());
//		Coach javaCoach = context.getBean("javaCoach",Coach.class);
//		System.out.println(javaCoach.getDailyWorkout());
		//close container
		context.close();
	}

}
