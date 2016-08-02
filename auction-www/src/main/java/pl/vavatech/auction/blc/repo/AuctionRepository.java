package pl.vavatech.auction.blc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.vavatech.auction.blc.model.Auction;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
}
