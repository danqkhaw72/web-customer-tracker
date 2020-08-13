package com.kamu.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {
	
	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations
	@Pointcut("execution(* com.kamu.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
		
	}
	
	// do the same for service and dao
	@Pointcut("execution(* com.kamu.springdemo.service.*.*(..))")
	private void forServicePackage() {
		
	}
	
	@Pointcut("execution(* com.kamu.springdemo.dao.*.*(..))")
	private void forDaoPackage() {
		
	}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {
		
	}
	
	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJointPoint) {
		
		// display method we are calling
		String theMethod = theJointPoint.getSignature().toShortString();
		System.out.println("\n===========>> in @Before: calling method: "+ theMethod);
		
	}
	
	// add @AfterReturning advice

}
