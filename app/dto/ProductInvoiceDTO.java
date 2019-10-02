package dto;

import models.Invoice;
import models.Product;
import models.ProductInvoice;

public class ProductInvoiceDTO {

    public Long productInvoiceId;
    public Product product;
    public Invoice invoice;
    public int amount;
    public Double price;

    public ProductInvoiceDTO(){}
    public ProductInvoiceDTO(int amount, Invoice invoice, Product product){
        this.invoice = invoice;
        this.product = product;
        this.amount = amount;
        this.price = getPrice(product,amount);
    }
    public ProductInvoiceDTO(ProductInvoice productInvoiceDTO){
        this.productInvoiceId = productInvoiceDTO.productInvoiceId;
        this.invoice = productInvoiceDTO.invoice;
        this.product = productInvoiceDTO.product;
        this.amount = productInvoiceDTO.amount;
        this.price = getPrice(productInvoiceDTO.product, productInvoiceDTO.amount);
    }

    public Double getPrice(Product product, int amount) {
        return product.itemPrice * amount;
    }
}
