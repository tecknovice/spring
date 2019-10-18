package springdemo.dao;

import java.util.List;

import springdemo.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void save(Customer customer);

	public Customer getCustomer(int id);

	public void delete(int id);

	public List<Customer> searchCustomers(String keyword);
}
