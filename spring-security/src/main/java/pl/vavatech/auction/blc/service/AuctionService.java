package pl.vavatech.auction.blc.service;

import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.vavatech.auction.blc.aop.Trace;
import pl.vavatech.auction.blc.model.Auction;
import pl.vavatech.auction.blc.repo.AuctionRepo;

@Transactional
@Service
public class AuctionService {
	@Value("${maxShippingPrice}")
	private BigDecimal maxShippingPrice;

	@Inject
	private AuctionRepo repo;

	@PreAuthorize("@strageMethodSecurityHandler.hasRight(true)")
	public Auction find(Long id) {
		return repo.find(id);
	}

	@Trace
	public List<Auction> findAll() {
		return repo.findAll();
	}

	@Trace
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Long insert(Auction auction) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		auction.setCreatorUserName(name);
		return repo.insert(auction);
	}

	@PreAuthorize("hasRole('ADMIN') or #auction.creatorUserName == authentication.name")
	public void update(Auction auction) {
		repo.update(auction);
	}

	public void delete(Long id) {
		repo.delete(id);
	}

}
