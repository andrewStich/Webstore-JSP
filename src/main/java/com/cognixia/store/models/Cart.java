package com.cognixia.store.models;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.persistence.Entity;

@Entity
public class Cart implements Serializable {

	private List<CartItem> items;

	public Cart() {
	}

	public Cart(List<CartItem> items) {
		super();
		this.items = items;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}

	public double getTotalPrice() {
		double total = 0.0;
		for (CartItem i : items) {
			total += i.getTotalPrice();
		}

		return total;
	}

	public String getTotalPriceCurrencyFormat() {
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
		double totalPrice = getTotalPrice();
		return currencyFormat.format(totalPrice);
	}

	public void addItem(CartItem cartItem) {
		String code = cartItem.getProduct().getCode();
		int quantity = cartItem.getQuantity();

		for (CartItem i : items) {
			if (i.getProduct().getCode().equals(code)) {
				// already exists
				i.setQuantity(quantity);
				return;
			}
		}

		items.add(cartItem);
	}

	public void removeItem(CartItem cartItem) {
		String code = cartItem.getProduct().getCode();
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i).getProduct().getCode().equals(code)) {
				items.remove(i);
				return;
			}
		}
	}

	@Override
	public String toString() {
		return "Cart [items=" + items + "]";
	}

}
