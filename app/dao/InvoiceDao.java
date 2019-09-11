package dao;

import models.Invoice;

import java.util.List;

public interface InvoiceDao {
    public void create(Invoice invoice);
    public void delete(int invoiceId);
    public void update(Invoice invoice);
    public List<Invoice> findAll();
    public Invoice findById(int id);
}
