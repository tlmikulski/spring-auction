package pl.vavatech.auction.blc.aop;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.google.common.base.Stopwatch;

@Aspect
@Component
public class LoggingAspect {

	Logger log = Logger.getLogger(LoggingAspect.class);

	@Pointcut("@annotation(pl.vavatech.auction.blc.aop.Trace)")
	public void performanceLogableMethod() {
	}

	@Around("performanceLogableMethod()")
	public Object monitpr(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature ms = (MethodSignature) pjp.getSignature();
		Method method = ms.getMethod();
		long maxTime = method.getAnnotation(Trace.class).value();

		Stopwatch sw = Stopwatch.createStarted();
		Object obj = pjp.proceed();
		sw.stop();

		long elapsed = sw.elapsed(TimeUnit.MILLISECONDS);
		if (elapsed > maxTime) {

			String params = Arrays.asList(pjp.getArgs()).stream()
					.map(arg -> ToStringBuilder.reflectionToString(arg))
					.collect(Collectors.joining(", "));

			log.error("++++++  method " + pjp.getSignature() + "( " + params + ") " + elapsed);
		}
		return obj;
	}
	// @Around("within(@org.springframework.stereotype.Service *)")
	// public Object trace(ProceedingJoinPoint proceedingJP) throws Throwable {
	// // advice
	// Stopwatch sw = Stopwatch.createStarted();
	// Object obj = proceedingJP.proceed();
	// sw.stop();
	// log.info("++++++ method " + proceedingJP.getSignature().getName() + " "
	// + sw.elapsed(TimeUnit.MILLISECONDS));
	// return obj;
	//
	// }
	//
	// @After("within(pl.vavatech..*)")
	// public void logAfter() {
	// System.out.println("@After:" + new Date());
	// }
	//
	// @Before("execution(*
	// pl.vavatech.auction.blc.service.AuctionService+.*(..))")
	// public void userAdvice() {
	// System.out.println("find my advice before your task.");
	// }
}
