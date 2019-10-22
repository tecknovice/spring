package jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class FullDemo {
	public static void main(String[] args) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
			System.out.println(student);
			System.out.println(student.getAddress());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
