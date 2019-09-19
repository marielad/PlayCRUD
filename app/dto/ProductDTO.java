package dto;

//import models.ProductInvoice;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {
    public  Long productId;
    public String productName;
    public double itemPrice;
    public List<ProductInvoiceDTO> productInvoicesDto = new ArrayList<>();

    public ProductDTO() {}
}
