package pl.vavatech.auction.blc.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import pl.vavatech.auction.blc.repo.OfferRepo;

@Service
public class OfferService {
	@Inject
	private OfferRepo repo;
}
