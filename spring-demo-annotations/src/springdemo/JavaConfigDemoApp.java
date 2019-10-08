package springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		//get bean from container
		Coach tennisCoach = context.getBean("tennisCoach",Coach.class);
		System.out.println(tennisCoach.getDailyWorkout());
		System.out.println(tennisCoach.getDailyFortune());
//		Coach javaCoach = context.getBean("javaCoach",Coach.class);
//		System.out.println(javaCoach.getDailyWorkout());
		//close container
		context.close();
	}

}
