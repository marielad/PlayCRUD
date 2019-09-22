package dto;

import models.Invoice;
import models.ProductInvoice;

import java.util.*;

public class InvoiceDTO {
    public Long invoiceId;
    public Double totalPrice;
    public Date invoiceDate;
    public List<ProductInvoiceDTO> productInvoiceDTOList = new ArrayList<>();

    public InvoiceDTO(){}
    public InvoiceDTO(Invoice invoice){
        this.invoiceId = invoice.invoiceId;
        this.totalPrice = invoice.totalPrice;
        this.invoiceDate = invoice.invoiceDate;
        this.productInvoiceDTOList = addProducts(invoice.productInvoices);
    }

    public List<ProductInvoiceDTO> addProducts(Set<ProductInvoice> productInvoiceSet){
        List<ProductInvoiceDTO> productInvoiceDTOList = new ArrayList<>();
        for (ProductInvoice productInvoice : productInvoiceSet) {
            productInvoiceDTOList.add(new ProductInvoiceDTO(productInvoice));
        }
        return productInvoiceDTOList;
    }

    public void addProduct(ProductInvoice productInvoice){
        this.productInvoiceDTOList.add(new ProductInvoiceDTO(productInvoice));
    }
    public void removeProduct(ProductInvoiceDTO productInvoiceDTO){
        this.productInvoiceDTOList.remove(productInvoiceDTO);
    }
}
