package springmvcdemo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloworldController {
	@RequestMapping("/show-form")
	public String showForm() {
		return "form";
	}
	@RequestMapping("/process-form-1")
	public String processForm1() {
		return "hello-world";
	}
	@RequestMapping("/process-form-2")
	public String processForm2(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		model.addAttribute("name","processForm2: " + name);
		return "hello-world";
	}
	@RequestMapping("/process-form-3")
	public String processForm3(@RequestParam("name") String name, Model model) {
		model.addAttribute("name","processForm3: "+name);
		return "hello-world";
	}
}
