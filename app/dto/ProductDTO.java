package dto;

import models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {
    public Long productId;
    public String productName;
    public Double itemPrice;
    public List<ProductInvoiceDTO> productInvoiceDTOList = new ArrayList<>();

    public ProductDTO() {}
    public ProductDTO(Long productId, String productName, Double itemPrice) {
        this.productId = productId;
        this.productName = productName;
        this.itemPrice = itemPrice;
    }

    public ProductDTO(Long id) {
        this.productId = id;
    }

    public ProductDTO(Product product) {
        this.productId = product.productId;
        this.productName = product.productName;
        this.itemPrice = product.itemPrice;
    }

}
