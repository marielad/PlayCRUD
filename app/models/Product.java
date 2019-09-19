package models;

import dto.ProductDTO;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
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

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    public Set<ProductInvoice> productInvoices = new HashSet<>();

    public Product(){}
    public Product(ProductDTO productDTO){
        this.productName = productDTO.productName;
        this.itemPrice = productDTO.itemPrice;
    }
}
