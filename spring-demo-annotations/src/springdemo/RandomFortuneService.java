package springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private String[] fortunes = {
			"win 1M in Lottery",
			"travel around the world",
			"meet a ideal partner"
	};
	private Random r = new Random();
	
	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		int index = r.nextInt(fortunes.length);
		return fortunes[index];
		
	}

}
