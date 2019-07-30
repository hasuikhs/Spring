package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Component
@Aspect
public class AnnotAdvice {
	static final Logger LOGGER = LoggerFactory.getLogger("root");

	@Pointcut("execution(* spring.biz.user.service.UserService.login(..))")
	public void pointcut_1() {}
	
	@Pointcut("execution(* spring.biz.*.service.*Service.*(..))")
	public void pointcut_2() {}
	
	//@Before("pointcut_1()")
	public void log(JoinPoint jp) {
		Object[] args = jp.getArgs();
		LOGGER.info(jp.toString());
	}
	
	@Around("pointcut_2()")
	public Object around(ProceedingJoinPoint pp) throws Throwable {
		System.out.println("--------around-----------");
		Object obj =  pp.proceed();
		System.out.println("--------around-----------");
		return obj;
	}
	
	@AfterThrowing(pointcut = "pointcut_2()",throwing = "e")
	public void ex(JoinPoint jp,Exception e) {
		LOGGER.error(jp.getSignature().getName()+" => "+e.getMessage());
	}
}







