package springdemo;

import org.springframework.stereotype.Component;

@Component
public class ConfigFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "learn how to config spring without XML";
	}

}
