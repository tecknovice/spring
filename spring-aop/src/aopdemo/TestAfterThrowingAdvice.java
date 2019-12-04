package aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import aopdemo.dao.AccountDAO;
import aopdemo.dao.MembershipDAO;
import aopdemo.entity.Account;

public class TestAfterThrowingAdvice {

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		//get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		//call business method
		try {
			accountDAO.throwException();
		} catch (Exception e) {
			System.out.println("An exception happened");
		}
		accountDAO.findAccounts();
		//close the context
		context.close();
	}

}
