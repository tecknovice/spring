package aopdemo.dao;

import org.springframework.stereotype.Component;

import aopdemo.entity.Account;

@Component
public class AccountDAO {
	public void add(Account account, boolean vip) {
		System.out.println("AccountDAO.add()");
	}
}
