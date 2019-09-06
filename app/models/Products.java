package models;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "Products", schema= "security")
@DynamicUpdate
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public  Long productId;

    @Column(name = "product_name", columnDefinition = "varchar", nullable = false)
    public String productName;

    @Column(name = "item_price", columnDefinition = "varchar", nullable = false)
    public double itemPrice;
}
