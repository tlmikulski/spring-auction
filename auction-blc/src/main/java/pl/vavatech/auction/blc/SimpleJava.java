package pl.vavatech.auction.blc;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.vavatech.auction.blc.service.UserService;

public class SimpleJava {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				SpringConfig.class);

		System.out.println(Arrays.asList(context.getBeanDefinitionNames()));

		UserService bean = context.getBean(UserService.class);

		System.out.println(bean);
	}
}
