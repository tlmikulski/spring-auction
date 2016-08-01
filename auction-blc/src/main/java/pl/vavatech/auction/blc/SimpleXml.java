package pl.vavatech.auction.blc;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SuppressWarnings("resource")
public class SimpleXml {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring/blc-context.xml");

		System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
	}
}
