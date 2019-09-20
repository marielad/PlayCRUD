package dto;

import models.Invoice;
import models.ProductInvoice;

import java.util.*;

public class InvoiceDTO {
    public Long invoiceId;
    public Double totalPrice;
    public Date invoiceDate;
    public Set<ProductInvoiceDTO> productInvoiceDTOSet = new LinkedHashSet<>();

    public InvoiceDTO(){}
    public InvoiceDTO(Invoice invoice){
        this.invoiceId = invoice.invoiceId;
        this.totalPrice = invoice.totalPrice;
        this.invoiceDate = invoice.invoiceDate;
        this.productInvoiceDTOSet = addProducts(invoice.productInvoices);
    }

    public Set<ProductInvoiceDTO> addProducts(Set<ProductInvoice> productInvoiceSet){
        Set<ProductInvoiceDTO> productInvoiceDTOSet = new HashSet<>();
        for (ProductInvoice productInvoice : productInvoiceSet) {
            productInvoiceDTOSet.add(new ProductInvoiceDTO(productInvoice));
        }
        return productInvoiceDTOSet;
    }

    public void addProduct(ProductInvoice productInvoice){
        this.productInvoiceDTOSet.add(new ProductInvoiceDTO(productInvoice));
    }
    public void removeProduct(ProductInvoiceDTO productInvoiceDTO){
        this.productInvoiceDTOSet.remove(productInvoiceDTO);
    }
}
