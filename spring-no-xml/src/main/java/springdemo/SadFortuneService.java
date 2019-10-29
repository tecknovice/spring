package springdemo;

public class SadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "An unlucky day";
	}

}
