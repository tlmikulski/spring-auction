package pl.vavatech.auction.blc.aop;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.validation.constraints.NotNull;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RuntimeNotNullAspect {
	@Pointcut("execution(* *(..,@javax.validation.constraints.NotNull  (*),..))")
	private void methodParamWithNotNull() {
	}

	@Pointcut("execution(@javax.validation.constraints.NotNull * *(..))")
	private void methodWithNotNullResult() {
	}

	@Around("methodWithNotNullResult()")
	public Object methodWithNotNullResultValidation(ProceedingJoinPoint pjp) throws Throwable {
		Object result = pjp.proceed();
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		if (result == null) {
			throw new IllegalArgumentException("Result is null :" + signature);
		}
		return result;
	}

	@Around("methodParamWithNotNull()")
	public Object methodParamWithNotNullValidation(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		Method method = signature.getMethod();
		Parameter[] parameters = method.getParameters();
		for (int i = 0; i < parameters.length; i++) {
			Object value = pjp.getArgs()[i];
			Parameter parameter = parameters[i];
			if (parameter.getAnnotation(NotNull.class) != null && value == null) {
				throw new IllegalArgumentException(parameter.getName() + " is null");
			}
		}
		Object obj = pjp.proceed();
		return obj;
	}
}
