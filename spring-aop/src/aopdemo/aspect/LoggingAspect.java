package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	@Before("execution(void aopdemo.dao.AccountDAO.add(aopdemo.entity.Account,..))")
	public void beforeAdd() {
		System.out.println("before advice on aopdemo.dao.AccountDAO.add()");
	}
	
	@Before("execution(* add*(..))")
	public void beforeAddStar() {
		System.out.println("before advice on add*()");
	}
	
	@Before("execution(* aopdemo.dao.*.*(..))")
	public void beforeAnyMethod() {
		System.out.println("before advice on any method in aopdemo.dao package");
	}
}
