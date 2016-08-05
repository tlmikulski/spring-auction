package pl.vavatech.auction.blc.jobs;

import java.time.LocalDateTime;

import javax.inject.Inject;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CopyOfCloseAuctionJob {
	@Inject
	AsynchService asynchService;

	@Scheduled(cron = "*/5 * * * * *")
	public void closeAuctions() {
		System.out.println("2 " + LocalDateTime.now());
		asynchService.async();
	}

}
