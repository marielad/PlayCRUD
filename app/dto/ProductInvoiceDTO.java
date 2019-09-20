package dto;

import models.ProductInvoice;

public class ProductInvoiceDTO {

    public  Long productInvoiceId;
    public ProductDTO product;
    public InvoiceDTO invoice;
    public int amount;
    public Double price;

    public ProductInvoiceDTO(){}
    public ProductInvoiceDTO(ProductInvoice productInvoice){
        this.productInvoiceId = productInvoice.productInvoiceId;
        this.product = new ProductDTO(productInvoice.product);
        this.invoice = new InvoiceDTO(productInvoice.invoice);
        this.amount = productInvoice.amount;
        this.price =  productInvoice.price;
    }
}
