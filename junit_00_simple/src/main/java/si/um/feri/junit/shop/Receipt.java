package si.um.feri.junit.shop;

import java.time.LocalDateTime;

public class Receipt {
	
	public Receipt(Buyer k, Item a, double p) {
		buyer = k;
		item = a;
		discount = p;
		purchase = LocalDateTime.now();
		fullPrice = a.getPrice();
		k.getPurchases().add(this);
	}

	private Buyer buyer;

	private Item item;

	private double fullPrice;

	private double discount;

	private LocalDateTime purchase;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public double getFullPrice() {
		return fullPrice;
	}

	public void setFullPrice(double fullPrice) {
		this.fullPrice = fullPrice;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public LocalDateTime getPurchase() {
		return purchase;
	}

	public void setPurchase(LocalDateTime purchase) {
		this.purchase = purchase;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
}
