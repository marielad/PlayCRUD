package dao;

import models.ProductInvoice;

import java.util.List;

public interface ProductInvoiceDao {
    List<ProductInvoice> findAll();
    List<Double> findByInvoiceId(Long id);
}
