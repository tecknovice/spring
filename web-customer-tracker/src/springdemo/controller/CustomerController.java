package springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springdemo.entity.Customer;
import springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers",customers);
		return "list";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("keyword") String keyword, Model model) {
		List<Customer> customers = customerService.searchCustomers(keyword);
		model.addAttribute("customers",customers);
		return "list";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "form";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("id") int id, Model model) {
		Customer customer = customerService.getCustomer(id);
		model.addAttribute("customer", customer);
		return "form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("customer") Customer customer) {
		customerService.save(customer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id, Model model) {
		customerService.delete(id);
		return "redirect:/customer/list";
	}
}
