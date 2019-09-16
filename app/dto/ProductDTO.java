package dto;

//import models.ProductInvoice;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {
    private  Long productId;
    private String productName;
    private double itemPrice;
    private List<ProductInvoiceDTO> productInvoicesDto = new ArrayList<>();

    public ProductDTO() {}

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
