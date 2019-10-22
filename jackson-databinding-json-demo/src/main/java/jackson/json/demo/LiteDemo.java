package jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LiteDemo {
	public static void main(String[] args) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Student student = mapper.readValue(new File("data/sample-lite.json"), Student.class);
			System.out.println(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
