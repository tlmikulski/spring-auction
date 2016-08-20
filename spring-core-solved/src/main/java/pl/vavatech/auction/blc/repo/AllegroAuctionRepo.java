package pl.vavatech.auction.blc.repo;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import pl.vavatech.auction.blc.model.Auction;

@Repository
@Primary
@Profile("prod")
public class AllegroAuctionRepo implements AuctionRepo {

	@Override
	public Auction find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auction> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long insert(Auction auction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Auction auction) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
