package springdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoRestController {
	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}
	@GetMapping("/object")
	public Object object() {
		return new Object();
	}
}
