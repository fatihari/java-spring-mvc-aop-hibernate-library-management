package com.fa.spring.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class bookLoggingAspect 
{
	//  Step-1 - initialize logger
	
	//	Step-2 - initialize pointcut for controller
	
	//	Step-3 - initialize pointcut for service
	
	//	Step-4 - initialize pointcut for dao
	
	//	Step-5 - combining poincuts
	
	//	Step-6 - add @Before advice
	
	//	Step-7 - add @AfterReturning advice
	
	//private Logger logger = Logger.getLogger(getClass().getName());
	private Logger logger = Logger.getLogger(this.getClass().getName());			//  Step-1
	
	@Pointcut("execution(* com.fa.spring.controller.*.*(..))")						//	Step-2
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.fa.spring.service.*.*(..))")							//	Step-3
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.fa.spring.dao.*.*(..))")								//	Step-4
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")	//	Step-5
	private void forAppFlow() {}
	
	@Before("forAppFlow()")															//	Step-6
	public void before(JoinPoint joinPoint)
	{
		//	Step-6.1 - display method we are calling
		String method = joinPoint.getSignature().toShortString();
		System.out.println("");
		logger.info("===>> in @Before: calling method: " + method);
		
		//	Step-6.2 - display the arguments to the method 
		Object[] args = joinPoint.getArgs();	//	get the arguments
		
		for (Object arg : args) {				//	display arguments
			logger.info("===>> argument: " + arg);
		}
	}
	
	@AfterReturning(pointcut = "forAppFlow()", returning = "result")				//	Step-7
	public void afterReturning(JoinPoint joinPoint, Object result) 
	{
		//	Step-7.1 - display method we are returning from
		String method = joinPoint.getSignature().toShortString();
		System.out.println("");
		logger.info("===>> in @AfterReturning: from method: " + method);
		
		//	Step-7.2 - display data returned
		logger.info("===>> result: " + result);
	}
}
