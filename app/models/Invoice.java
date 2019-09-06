package models;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;

@Entity
@Table(name = "Invoice")
@DynamicUpdate
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long invoiceId;

    @Column(name = "amount", columnDefinition = "integer", nullable = false)
    public int amount;

    @Column(name = "total_price", columnDefinition = "double", nullable = false)
    public double totalPrice;

    @Column(name = "invoice_date", columnDefinition = "date", nullable = false)
    public Date invoiceDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="invoice_products", joinColumns = {
            @JoinColumn(name = "invoiceId", nullable = false, updatable = false, foreignKey = @ForeignKey(name = "FK_INVOICE_PRODUCT"))},
            inverseJoinColumns = {@JoinColumn(name = "productId", nullable = false, updatable = false)
            })
    public Set<Product> products = new HashSet<>();
}

