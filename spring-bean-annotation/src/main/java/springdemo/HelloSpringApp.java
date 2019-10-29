package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		//load the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//retrieve bean from spring container
		Coach coach = context.getBean("trackCoach",Coach.class);
		//call methods from bean
		System.out.println(coach.getDailyWorkout());
		//close the context
		context.close();
	}

}
