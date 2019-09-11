package models;

import dto.ProductDTO;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Products", schema= "security")
@DynamicUpdate
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    public  Long productId;

    @Column(name = "product_name", columnDefinition = "varchar", nullable = false)
    public String productName;

    @Column(name = "item_price", columnDefinition = "varchar", nullable = false)
    public double itemPrice;

    @OneToMany(mappedBy = "product")
    public Set<ProductInvoice> productInvoices = new HashSet<>();

    public Product(){}

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

    public Set<ProductInvoice> getProductInvoices() {
        return productInvoices;
    }

    public void setProductInvoices(Set<ProductInvoice> productInvoices) {
        this.productInvoices = productInvoices;
    }
}
