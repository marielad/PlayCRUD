package dao;

import models.Product;
import models.ProductInvoice;

import java.util.List;

public interface ProductInvoiceDao {
    List<ProductInvoice> findAll();
    List<ProductInvoice> findByInvoiceId(Long id);
    List<Product> productsByInvoiceId(Long id);

}
