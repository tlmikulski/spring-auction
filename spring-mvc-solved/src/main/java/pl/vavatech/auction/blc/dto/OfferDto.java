package pl.vavatech.auction.blc.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class OfferDto {
	@NotNull
	private String userName;
	@NotNull
	private Integer auctionNumber;
	@NotNull
	private BigDecimal bid;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public BigDecimal getBid() {
		return bid;
	}

	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}

	public Integer getAuctionNumber() {
		return auctionNumber;
	}

	public void setAuctionNumber(Integer auctionNumber) {
		this.auctionNumber = auctionNumber;
	}
}
