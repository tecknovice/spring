package springdemo;

import java.util.ArrayList;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {
//	@Value("${fortunes}")
//	private String[] fortunes;
	
	@Value("${specialFortune1}")
	private String specialFortune1;
	@Value("${specialFortune2}")
	private String specialFortune2;
	
	private ArrayList<String> specialFortunes;
	
	private Random r = new Random();
	
	@PostConstruct
	private void init() {
		specialFortunes = new ArrayList<String>();
		specialFortunes.add(specialFortune1);
		specialFortunes.add(specialFortune2);
	}
	
	@Override
	public String getFortune() {
		int index = r.nextInt(specialFortunes.size());
		return specialFortunes.get(index);
	}

}
