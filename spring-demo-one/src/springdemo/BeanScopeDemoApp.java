package springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		Coach coach = context.getBean("myCoach",Coach.class);
		Coach alphaCoach = context.getBean("myCoach",Coach.class);
		boolean result = (coach == alphaCoach);
		System.out.println("result: "+result);
		System.out.println("coach: "+coach);
		System.out.println("alphaCoach: "+alphaCoach);
		context.close();
	}

}
