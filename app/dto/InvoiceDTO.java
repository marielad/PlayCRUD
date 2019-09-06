package dto;

import java.util.*;

public class InvoiceDTO {
    public Long invoiceId;
    public int amount;
    public double totalPrice;
    public Date invoiceDate;
    public Set<ProductDTO> products = new LinkedHashSet<>();
}
