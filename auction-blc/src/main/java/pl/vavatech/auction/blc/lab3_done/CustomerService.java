package pl.vavatech.auction.blc.lab3_done;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@PostConstruct
	private void init() {
		System.out.println("init");
	}

	@PreDestroy
	private void destroy() {
		System.out.println("destroy");
	}

}
