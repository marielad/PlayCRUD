package models;

import dto.ProductDTO;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
@DynamicUpdate
public class Product  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    public  Long productId;

    @Column(name = "product_name", columnDefinition = "varchar", nullable = false)
    public String productName;

    @Column(name = "item_price", columnDefinition = "varchar", nullable = false)
    public Double itemPrice;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Set<ProductInvoice> productInvoices = new HashSet<>();

    public Product(){}
    public Product(Long productId){
        this.productId = productId;
    }

    public Product(Long productId, String productName, Double itemPrice) {
        this.productId = productId;
        this.productName = productName;
        this.itemPrice = itemPrice;
    }

    public Product(ProductDTO productDTO){
        this.productId = productDTO.productId;
        this.productName = productDTO.productName;
        this.itemPrice = productDTO.itemPrice;
    }
}
