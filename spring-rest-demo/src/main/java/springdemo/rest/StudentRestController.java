package springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> students;
	
	@PostConstruct
	void initialize() {
		 students = new ArrayList<Student>();
		students.add(new Student("Mary", "Smith"));
		students.add(new Student("John", "Sketh"));
		students.add(new Student("Dan", "Simpson"));
	}
	
	@GetMapping("/students")
	public List<Student> list(){
		return students;
	}
	@GetMapping("/students/{index}")
	public Student get(@PathVariable int index){
		if(index < 0 || index >= students.size())
			throw new StudentNotFoundException("Student not found " + index);
		return students.get(index);
	}
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception){
//		StudentErrorResponse error = new StudentErrorResponse();
//		error.setStatus(HttpStatus.NOT_FOUND.value());
//		error.setMessage(exception.getMessage());
//		error.setTimestamp(System.currentTimeMillis());
//		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
//	}
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(Exception exception){
//		StudentErrorResponse error = new StudentErrorResponse();
//		error.setStatus(HttpStatus.BAD_REQUEST.value());
//		error.setMessage(exception.getMessage());
//		error.setTimestamp(System.currentTimeMillis());
//		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
//	}
}
