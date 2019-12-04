package aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import aopdemo.entity.Account;

@Aspect
@Component
@Order(6)
public class AfterFinallyAspect {
	
	@After("execution(* aopdemo.dao.AccountDAO.throwException(..))")
	public void afterFinallyAdvice(JoinPoint joinPoint) {
		System.out.println("afterFinallyAdvice");
	}
	
}
