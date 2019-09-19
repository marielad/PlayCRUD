package dto;

import java.util.*;

public class InvoiceDTO {
    public Long invoiceId;
    public double totalPrice;
    public Date invoiceDate;
    public Set<ProductInvoiceDTO> productInvoiceDTOSet = new LinkedHashSet<>();

    public InvoiceDTO(){}
}
