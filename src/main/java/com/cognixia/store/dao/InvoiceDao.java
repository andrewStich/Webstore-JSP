package com.cognixia.store.dao;

import java.util.List;

import com.cognixia.store.models.Invoice;

public interface InvoiceDao {

	public Invoice getInvoice(long invoiceId);
	public List<Invoice> getAllInvoices();
	public List<Invoice> getUserInvoices(long userId);
	public boolean createInvoice(Invoice invoice);
	public boolean updateInvoice(Invoice invoice);
	public boolean deleteInvoice(long invoiceId);
}
