package springdemo.service;

import java.util.List;

import springdemo.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();
	public List<Customer> searchCustomers(String keyword);
	public void save(Customer customer);
	public Customer getCustomer(int id);
	public void delete(int id);
}
