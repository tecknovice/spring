package springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	
	private String[] fortunes = {"inherited","get lottery","have girl friend"};
	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		Random r=new Random();
        int randomNumber=r.nextInt(fortunes.length);
		return fortunes[randomNumber];
	}

}
