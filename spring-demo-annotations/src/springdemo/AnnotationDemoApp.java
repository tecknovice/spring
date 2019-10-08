package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
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
