package springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

	@Override
	public void save(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		return customer;
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, id);
		session.delete(customer);		
	}

	@Override
	public List<Customer> searchCustomers(String keyword) {
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> query ;
		if(keyword !=null && keyword.trim().length()>0) {
			query = session.createQuery(
					"from Customer where lower(firstName) like :keyword or lower(lastName) like :keyword order by lastName",
					Customer.class);
			query.setParameter("keyword", "%"+keyword+"%");
		}else {
			query = session.createQuery("from Customer order by lastName", Customer.class);
		}
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

}
