package pl.vavatech.auction.blc.service;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.vavatech.auction.blc.aop.Trace;
import pl.vavatech.auction.blc.model.Auction;
import pl.vavatech.auction.blc.repo.AuctionRepo;
import pl.vavatech.auction.blc.repo.FindCriteria;

@Transactional
@Service
public class AuctionService {
	@Value("${maxShippingPrice}")
	private BigDecimal maxShippingPrice;

	@Inject
	private AuctionRepo repo;

	public Auction find(Long id) {
		return repo.find(id);
	}

	@Trace
	@Transactional(readOnly = true)
	@NotNull
	public List<Auction> findAll() {
		return repo.findAll();
	}

	@Trace
	@Transactional(readOnly = true)
	public List<Auction> findAll(// @NotNull
			FindCriteria findCriteria) {
		return repo.findAll(findCriteria);
	}

	@Trace
	public Long insert(Auction auction) {
		return repo.insert(auction);
	}

	public void update(Auction auction) {
		repo.update(auction);
	}

	public void delete(Long id) {
		repo.delete(id);
	}

}
