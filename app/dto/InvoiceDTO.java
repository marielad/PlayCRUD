package dto;

import models.Invoice;
import models.ProductInvoice;

import java.time.LocalDate;
import java.util.*;

public class InvoiceDTO {
    public Long invoiceId;
    public Double totalPrice;
    public LocalDate invoiceDate;
    public List<ProductInvoiceDTO> productInvoiceDTOList = new ArrayList<>();

    public InvoiceDTO(){}
    public InvoiceDTO(Double totalPrice){
        this.invoiceDate = LocalDate.now();
        this.totalPrice = totalPrice;
    }
    public InvoiceDTO(Invoice invoice){
        this.invoiceId = invoice.invoiceId;
        this.invoiceDate = invoice.invoiceDate;
        this.totalPrice = invoice.totalPrice;
    }
    public List<ProductInvoiceDTO> addProducts(List<ProductInvoice> productInvoiceList){
        for (int i = 0; i < productInvoiceList.size(); i++) {
            this.productInvoiceDTOList.add(new ProductInvoiceDTO(productInvoiceList.get(i)));
        }
        return productInvoiceDTOList;
    }

    public void addProduct(ProductInvoiceDTO productInvoice){
        this.productInvoiceDTOList.add(productInvoice);
    }
    public void removeProduct(ProductInvoiceDTO productInvoice){
        this.productInvoiceDTOList.remove(productInvoice);
    }
}
