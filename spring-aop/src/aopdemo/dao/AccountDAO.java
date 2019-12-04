package aopdemo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import aopdemo.entity.Account;

@Component
public class AccountDAO {
	public void add(Account account, boolean vip) {
		System.out.println("AccountDAO.add()");
	}
	public List<Account> findAccounts(){
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account("Kevin", "Gold"));
		accounts.add(new Account("tecknovice", "Diamond"));
		accounts.add(new Account("Hung Nguyen", "Silver"));
		return accounts;
	}
	
	public void throwException() throws Exception {
		throw new Exception("this is an exception");
	}
	
	public Object fiveSecond() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
		}
		return new Object();
	}
}
