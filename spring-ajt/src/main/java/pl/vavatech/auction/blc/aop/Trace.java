package pl.vavatech.auction.blc.aop;

@java.lang.annotation.Target(value = { java.lang.annotation.ElementType.METHOD })
@java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface Trace {
	long value() default 5L;
}
