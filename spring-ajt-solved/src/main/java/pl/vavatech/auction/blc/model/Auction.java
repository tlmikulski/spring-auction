package pl.vavatech.auction.blc.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import pl.vavatech.auction.www.component.CurrencyFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Auction extends BaseEntity {
	private static AtomicInteger NUMBER_SEQ = new AtomicInteger(1);
	@NotNull
	@Size(max = 10)
	private String title;
	private String description;

	private BigDecimal currentPrice = BigDecimal.ZERO;

	@CurrencyFormat
	private BigDecimal shippingPrice = new BigDecimal("9.99");
	private AuctionType auctionType = AuctionType.BIDDING;
	private Integer number = NUMBER_SEQ.getAndIncrement();
	private LocalDateTime expiryDate = LocalDateTime.now();
	@JsonIgnore
	@OneToMany
	private Set<Offer> offers = new HashSet();

	public Auction() {
	}

	public Auction(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
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

	public Set<Offer> getOffers() {
		return offers;
	}

	public void setOffers(Set<Offer> offers) {
		this.offers = offers;
	}
}
