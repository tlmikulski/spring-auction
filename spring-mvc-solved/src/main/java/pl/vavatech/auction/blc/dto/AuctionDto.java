package pl.vavatech.auction.blc.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import pl.vavatech.auction.blc.model.AuctionType;

public class AuctionDto {
	private Long id;
	private String title;
	private String description;

	private BigDecimal shippingPrice;
	private AuctionType auctionType;

	private LocalDateTime expiryDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getShippingPrice() {
		return shippingPrice;
	}

	public void setShippingPrice(BigDecimal shippingPrice) {
		this.shippingPrice = shippingPrice;
	}

	public AuctionType getAuctionType() {
		return auctionType;
	}

	public void setAuctionType(AuctionType auctionType) {
		this.auctionType = auctionType;
	}

	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

}
