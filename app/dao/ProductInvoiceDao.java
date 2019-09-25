package dao;

import models.Product;
import models.ProductInvoice;

import java.util.List;

public interface ProductInvoiceDao {
    List<ProductInvoice> findAll();
    List<Double> priceByInvoiceId(Long id);
    List<Product> productsByInvoiceId(Long id);

}
