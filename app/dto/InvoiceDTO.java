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
    }

}
