package models;

import dto.ProductDTO;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "Products", schema= "security")
@DynamicUpdate
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public  Long productId;

    @Column(name = "product_name", columnDefinition = "varchar", nullable = false)
    public String productName;

    @Column(name = "item_price", columnDefinition = "varchar", nullable = false)
    public double itemPrice;

    @Column(name = "amount", columnDefinition = "integer", nullable = false)
    public int amount;

    @Column(name = "total_price", columnDefinition = "double", nullable = false)
    public double totalPrice;

    public Product(){}
    public Product(ProductDTO productDTO){
        this.productId = productDTO.productId;
        this.productName = productDTO.productName;
        this.itemPrice = productDTO.itemPrice;
    }
}
