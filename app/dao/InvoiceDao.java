package dao;

import models.Invoice;

import java.util.List;

public interface InvoiceDao{
    List<Invoice> findAll();
    Invoice findByPk(Long id);
    Invoice create(Invoice invoice);
    Invoice update(Invoice invoice);
    Invoice delete(Invoice invoice);
}
