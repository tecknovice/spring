package aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import aopdemo.entity.Account;

@Aspect
@Component
@Order(-2)
public class BeforeAspect {
	
	@Pointcut("execution(* aopdemo.dao.*.*(..))")
	private void pointCutExpression() {}
	
	@Before("execution(void aopdemo.dao.AccountDAO.add(aopdemo.entity.Account,..))")
	public void beforeAdd() {
		System.out.println("before advice on aopdemo.dao.AccountDAO.add()");
	}
	
	@Before("execution(* add*(..))")
	public void beforeAddStar() {
		System.out.println("before advice on add*()");
	}
	
	@Before("execution(* aopdemo.dao.*.*(..))")
	public void beforeAnyMethod(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		System.out.println("joinPoint signature: " + signature);
		Object[] args = joinPoint.getArgs();
		for (Object arg : args) {
			System.out.println(arg);
		}
//		System.out.println("before advice on any method in aopdemo.dao package");
	}
}
