package com.cognixia.store.models;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Invoice implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long invoiceId;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<CartItem> items;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timeStamp;

	private boolean processed;

	public Invoice() {
	}

	public Invoice(long invoiceId, List<CartItem> items, Date timeStamp, boolean processed) {
		super();
		this.invoiceId = invoiceId;
		this.items = items;
		this.timeStamp = timeStamp;
		this.processed = processed;
	}

	public long getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> itmes) {
		this.items = itmes;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	public double getInvoiceTotal() {
		double total = 0.0;
		for (CartItem i : items) {
			total += i.getTotalPrice();
		}

		return total;
	}

	public String getInvoiceTotalCurrencyFormat() {
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
		double total = getInvoiceTotal();
		return currencyFormat.format(total);
	}

	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", items=" + items + ", timeStamp=" + timeStamp + ", processed="
				+ processed + "]";
	}

}
