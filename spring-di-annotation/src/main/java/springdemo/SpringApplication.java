package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {

	public static void main(String[] args) {
		//load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//retrieve bean from spring container
//		Coach coach = context.getBean("trackCoach",Coach.class);
//		Coach coach = context.getBean("cricketCoach",Coach.class);
		Coach coach = context.getBean("tennisCoach",Coach.class);
		//call methods from bean
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		//close the context
		context.close();
	}

}
