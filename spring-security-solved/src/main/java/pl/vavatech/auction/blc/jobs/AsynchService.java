package pl.vavatech.auction.blc.jobs;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsynchService {
	@Async
	public void async() {
		System.out.println("async");
		if (2 > 1) {
			throw new NullPointerException("uff");
		}
	}
}
