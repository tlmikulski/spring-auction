package pl.vavatech.auction.blc.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import pl.vavatech.auction.blc.model.Auction;

public interface AutoAuctionRepo extends JpaRepository<Auction, Long>, JpaSpecificationExecutor<Auction> {

	Optional<Auction> findByTitle(String title);
}
