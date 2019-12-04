package aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(6)
public class AroundAspect {
	
	@Around("execution(* aopdemo.dao.AccountDAO.fiveSecond(..))")
	public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		//get begin timestamp
		long start = System.currentTimeMillis();
		//execute the method
		Object result = proceedingJoinPoint.proceed();
		//get end timestamp
		long end = System.currentTimeMillis();
		//compute duration and display it
		long duration = end - start;
		System.out.println("Duration: " + duration/1000.0 + " seconds");
		return result;
	}
	
}
