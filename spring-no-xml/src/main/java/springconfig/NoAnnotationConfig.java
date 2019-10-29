package springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springdemo.Coach;
import springdemo.FortuneService;
import springdemo.SadFortuneService;
import springdemo.SwimCoach;

@Configuration
public class NoAnnotationConfig {

	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	@Bean
	public Coach myCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
