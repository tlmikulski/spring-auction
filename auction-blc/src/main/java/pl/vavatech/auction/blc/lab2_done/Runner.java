package pl.vavatech.auction.blc.lab2_done;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				BusinessConfig.class);

		InvoiceService invoiceService = context.getBean(InvoiceService.class);
		System.out.println(invoiceService);

	}

}
