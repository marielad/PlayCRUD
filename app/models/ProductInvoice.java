package models;

import dto.ProductInvoiceDTO;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_invoice")
@DynamicUpdate
public class ProductInvoice implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public  Long productInvoiceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "PRODUCT_ID_FK"))
    public Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id", foreignKey = @ForeignKey(name = "INVOICE_ID_FK"))
    public Invoice invoice;

    @Column(name = "amount", columnDefinition = "integer", nullable = false)
    public int amount;

    @Column(name = "price",  columnDefinition = "double precision", nullable = false)
    public Double price;

    public ProductInvoice(){}
    public ProductInvoice(ProductInvoiceDTO productInvoiceDTO){
        this.product = new Product(productInvoiceDTO.product);
        this.invoice = new Invoice(productInvoiceDTO.invoice);
        this.amount = productInvoiceDTO.amount;
        this.price = productInvoiceDTO.price;
    }

}
