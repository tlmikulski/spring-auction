package pl.vavatech.auction.blc.aop.sample;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

public class JavaMagic {

	public static void main(String[] args) {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.addAdvice(new MethodInterceptor() {

			@Override
			public Object invoke(MethodInvocation invocation) throws Throwable {
				return "Pobralem dane dla " + invocation.getArguments()[0];
			}
		});

		proxyFactory.setInterfaces(CustomerService.class);
		CustomerService proxy = (CustomerService) proxyFactory.getProxy();

		String find = proxy.find(10L);
		System.out.println(find);

		// proxyFactory.setTarget(new InvoiceService());
		//
		// InvoiceService proxy = (InvoiceService) proxyFactory.getProxy();
		//
		// String find = proxy.find(10L);
		// System.out.println(find);

	}
}
