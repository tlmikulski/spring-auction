package pl.vavatech.auction.blc.lab3_done;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				BusinessConfig.class);

		CustomerService customerService = context
				.getBean(CustomerService.class);
		System.out.println(customerService);

		((ConfigurableApplicationContext) context).close();

	}

}
