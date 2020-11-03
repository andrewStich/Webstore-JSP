package com.cognixia.store.models;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class CartItem implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long itemId;

	@OneToOne
	public Product product;

	private int quantity = 1;

	public CartItem() {
	}

	public CartItem(long itemId, Product product, int quantity) {
		super();
		this.itemId = itemId;
		this.product = product;
		this.quantity = quantity;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return product.getPrice().doubleValue() * quantity;
	}

	public String getTotalPriceCurrencyFormat() {
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
		return currencyFormat.format(getTotalPrice());
	}

	@Override
	public String toString() {
		return "CartItem [itemId=" + itemId + ", product=" + product + ", quantity=" + quantity + "]";
	}

}
