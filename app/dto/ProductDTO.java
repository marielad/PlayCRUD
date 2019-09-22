package dto;

import models.Product;
import models.ProductInvoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductDTO {
    public Long productId;
    public String productName;
    public Double itemPrice;
    public List<ProductInvoiceDTO> productInvoiceDTOList = new ArrayList<>();

    public ProductDTO() {}
    public ProductDTO(Long productId, String productName, Double itemPrice, List<ProductInvoiceDTO> productInvoiceDTOS) {
        this.productId = productId;
        this.productName = productName;
        this.itemPrice = itemPrice;
        this.productInvoiceDTOList = productInvoiceDTOS;
    }

    public ProductDTO(Product product) {
        this.productId = product.productId;
        this.productName = product.productName;
        this.itemPrice = product.itemPrice;
        this.productInvoiceDTOList = addInvoices(product.productInvoices);
    }

    public List<ProductInvoiceDTO> addInvoices(Set<ProductInvoice> productInvoiceSet){
        List<ProductInvoiceDTO> productInvoiceDTOList = new ArrayList<>();
        for (ProductInvoice productInvoice : productInvoiceSet) {
            productInvoiceDTOList.add(new ProductInvoiceDTO(productInvoice));
        }
        return productInvoiceDTOList;
    }

    public void addInvoice(ProductInvoice productInvoice){
        this.productInvoiceDTOList.add(new ProductInvoiceDTO(productInvoice));
    }
    public void removeInvoice(ProductInvoiceDTO productInvoiceDTO){
        this.productInvoiceDTOList.remove(productInvoiceDTO);
    }
}
