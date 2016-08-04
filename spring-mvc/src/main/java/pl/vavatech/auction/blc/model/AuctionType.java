package pl.vavatech.auction.blc.model;

public enum AuctionType {
	BIDDING("Bidding"), BUY_NOW("Buy now");

	private final String fullName;

	private AuctionType(String fullName) {
		this.fullName = fullName;
	}

	public String getFullName() {
		return fullName;
	}

}
