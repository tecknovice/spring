package springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	@Bean
	public ConfigFortuneService configFortuneService() {
		return new ConfigFortuneService();
	}
	@Bean
	public ConfigCoach configCoach() {
		return new ConfigCoach(configFortuneService());
	}
}
