package springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LoggingAspect {
	
	//setup logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	//setup pointcut declaration
	@Pointcut("execution(* springdemo.controller.*.*(..))")
	private void controllerPointCut() {}
	
	@Pointcut("execution(* springdemo.service.*.*(..))")
	private void servicePointCut() {}

	@Pointcut("execution(* springdemo.dao.*.*(..))")
	private void daoPointCut() {}
	
	@Pointcut("controllerPointCut() || servicePointCut() || daoPointCut()")
	private void pointCut() {}
	
	//add @Before advice
	@Before("pointCut()")
	public void before(JoinPoint joinPoint) {
		//display method that we are calling
		String method = joinPoint.getSignature().toShortString();
		logger.info("@Before calling method " + method);
		//display parameters
		Object[] args = joinPoint.getArgs();		
		for (Object arg : args) {
			logger.info("argument: " + arg.toString());			
		}
	}
	
	//add @AfterReturning advice
	@AfterReturning(pointcut = "pointCut()", returning = "result")
	public void after(JoinPoint joinPoint, Object result) {
		//display method that we are calling
		String method = joinPoint.getSignature().toShortString();
		logger.info("@AfterReturning from method " + method);		
		//display returned data
		logger.info(result.toString());
	}
}
