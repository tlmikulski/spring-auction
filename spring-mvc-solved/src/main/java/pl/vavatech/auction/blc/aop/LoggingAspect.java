package pl.vavatech.auction.blc.aop;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.google.common.base.Stopwatch;

@Aspect
@Component
public class LoggingAspect {

	Logger log = Logger.getLogger(LoggingAspect.class);

	@Pointcut("execution(@pl.vavatech.auction.blc.aop.Monitor * *(..))")
	public void performanceLogableMethod() {
	}

	@Around("within(@org.springframework.stereotype.Service *)")
	// pointcut
	public Object trace(ProceedingJoinPoint proceedingJP) throws Throwable { // advice
		Stopwatch sw = Stopwatch.createStarted();
		Object obj = proceedingJP.proceed();
		sw.stop();
		log.info("++++++  method " + proceedingJP.getSignature().getName()
				+ " " + sw.elapsed(TimeUnit.MILLISECONDS));
		return obj;

	}

	@Around("performanceLogableMethod()")
	public Object monitpr(ProceedingJoinPoint proceedingJP) throws Throwable { // advice
		Stopwatch sw = Stopwatch.createStarted();
		Object obj = proceedingJP.proceed();
		sw.stop();
		log.info("monitor ++++++  method "
				+ proceedingJP.getSignature().getName() + " "
				+ sw.elapsed(TimeUnit.MILLISECONDS));
		return obj;

	}

	@After("execution(* pl.vavatech.*.*(..))")
	public void logAfter() {
		System.out.println("@After:" + new Date());
	}

	@Before("execution(* pl.vavatech.auction.blc.service.AuctionService+.*(..))")
	public void userAdvice() {
		System.out.println("find my advice before your task.");
	}
}
