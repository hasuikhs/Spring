package AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect // Aspect = Pointcut + advice
public class TimeCheckAdvice {
	
	
	@Pointcut("execution(* spring.biz.user.service.UserService.*(..))")
	public void timecheck() {}
	
	@Around("timecheck()")
	public Object time(ProceedingJoinPoint pp) throws Throwable{
		StopWatch sw = new StopWatch();
		
		System.out.println("=== time check advice around start ===");
		sw.start();
		Object obj = pp.proceed();
		System.out.println("=== time check advice around end ===");
		sw.stop();
		
		long time = sw.getTotalTimeMillis();
		
		String methodName = pp.getSignature().getName();
				
		System.out.println("메소드 이름 : " + methodName + " => " + time + "(ms)");
		
		return obj;
	}
}
