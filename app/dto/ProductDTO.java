package dto;

//import models.ProductInvoice;

import models.Product;
import models.ProductInvoice;

import java.util.HashSet;
import java.util.Set;

public class ProductDTO {
    public Long productId;
    public String productName;
    public Double itemPrice;
    public Set<ProductInvoiceDTO> productInvoiceDTOSet = new HashSet<>();

    public ProductDTO() {}
    public ProductDTO(Product product) {
        this.productId = product.productId;
        this.productName = product.productName;
        this.itemPrice = product.itemPrice;
        this.productInvoiceDTOSet = addInvoices(product.productInvoices);
    }

    public Set<ProductInvoiceDTO> addInvoices(Set<ProductInvoice> productInvoiceSet){
        Set<ProductInvoiceDTO> productInvoiceDTOSet = new HashSet<>();
        for (ProductInvoice productInvoice : productInvoiceSet) {
            productInvoiceDTOSet.add(new ProductInvoiceDTO(productInvoice));
        }
        return productInvoiceDTOSet;
    }

    public void addInvoice(ProductInvoice productInvoice){
        this.productInvoiceDTOSet.add(new ProductInvoiceDTO(productInvoice));
    }
    public void removeInvoice(ProductInvoiceDTO productInvoiceDTO){
        this.productInvoiceDTOSet.remove(productInvoiceDTO);
    }
}
