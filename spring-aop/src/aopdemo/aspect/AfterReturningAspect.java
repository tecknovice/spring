package aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import aopdemo.entity.Account;

@Aspect
@Component
@Order(2)
public class AfterReturningAspect {
	
	@AfterReturning(pointcut = "execution(* aopdemo.dao.AccountDAO.findAccounts(..))", returning = "accounts")
	public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> accounts) {
		toUpperCase(accounts);
	}

	private void toUpperCase(List<Account> accounts) {
		for (Account account : accounts) {
			account.setName(account.getName().toUpperCase());
			account.setLevel(account.getLevel().toUpperCase());
		}
		
	}
}
