package pl.vavatech.auction.blc.jobs;

import java.time.LocalDateTime;

import javax.inject.Inject;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CloseAuctionJob {
	@Inject
	AsynchService asynchService;

	@Scheduled(cron = "*/5 * * * * *")
	public void closeAuctions() {
		System.out.println("1 " + LocalDateTime.now());
		asynchService.async();
	}

}
